package com.example.SpringBoot_RESTfulAPI.Services;

import com.example.SpringBoot_RESTfulAPI.Entities.Student;

import java.util.List;
import java.util.Optional;

public interface studentService {

    boolean adduser(Student student);

    List<Student> getStudents();

    Optional<Student> getStudentByRollNo(int rollNo);

    Student updateStudent(Student student, int rollNo);

    Student deleteStudentById(int rollNo);
}
