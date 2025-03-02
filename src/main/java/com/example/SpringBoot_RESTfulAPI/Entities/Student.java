package com.example.SpringBoot_RESTfulAPI.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table
public class Student {

    @Id
    @Column
    private int rollno;
    @Column
    private String name;
    @Column
    private int age;
    @Column
    private float marks;

}
