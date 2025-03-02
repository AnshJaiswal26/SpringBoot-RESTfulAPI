package com.example.SpringBoot_RESTfulAPI.DAO;

import com.example.SpringBoot_RESTfulAPI.Entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface studentRepository extends JpaRepository<Student, Integer> {

}
