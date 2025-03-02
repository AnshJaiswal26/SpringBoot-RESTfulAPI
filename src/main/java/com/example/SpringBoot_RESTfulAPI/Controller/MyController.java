package com.example.SpringBoot_RESTfulAPI.Controller;

import com.example.SpringBoot_RESTfulAPI.Entities.Student;
import com.example.SpringBoot_RESTfulAPI.Services.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {

    @Autowired
    studentService studentService;

    @PostMapping("/student")
    public ResponseEntity<?> insertStudentDetails(@RequestBody Student student) {
        try{
            studentService.adduser(student);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/student")
    public List<Student> getAllStudents() {
        return studentService.getStudents();
    }

    @GetMapping("/student/{Id}")
    public ResponseEntity<Student> getStudentDetailsById(@PathVariable int Id) {
        Student student = studentService.getStudentByRollNo(Id).orElse(null);
        if (student == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PutMapping("student/{Id}")
    public ResponseEntity<Student> updateStudentDetails(@RequestBody Student student, @PathVariable int Id) {
        Student student1 = studentService.updateStudent(student, Id);

        if (student1 == null) {
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(student);
        }
    }

    @DeleteMapping("student/{Id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int Id) {

        Student student = studentService.deleteStudentById(Id);
        if(student == null) {
            return ResponseEntity.notFound().build();
        }else return ResponseEntity.noContent().build();
//        return ResponseEntity.ok("Student deleted successfully");
    }
}
