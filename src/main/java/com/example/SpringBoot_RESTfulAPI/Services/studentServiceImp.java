package com.example.SpringBoot_RESTfulAPI.Services;

import com.example.SpringBoot_RESTfulAPI.DAO.studentRepository;
import com.example.SpringBoot_RESTfulAPI.Entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class studentServiceImp implements studentService {

    @Autowired
    private studentRepository studentRepository;

    @Override
    public boolean adduser(Student student) {

        try {
            studentRepository.save(student);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Student> getStudents() {
        List<Student> list = null;
        try{
            list = studentRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Optional<Student> getStudentByRollNo(int rollNo) {
        return studentRepository.findById(rollNo);
    }

    @Override
    public Student updateStudent(Student student, int rollNo) {
        Student student1 = studentRepository.findById(rollNo).orElse(null);

        if(student1 != null) {
            studentRepository.save(student);
            return student;
        }else return null;
//        }else throw new RuntimeException("Student not found with roll no " + rollNo) ;
    }

    @Override
    public Student deleteStudentById(int rollNo) {
        Student student = studentRepository.findById(rollNo).orElse(null);

        if(student != null) {
            studentRepository.deleteById(rollNo);
            return student;
        }else return null;
//        }else throw new RuntimeException("Student not found with roll no " + rollNo);
    }
}
