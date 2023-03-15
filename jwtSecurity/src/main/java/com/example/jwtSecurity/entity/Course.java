package com.example.jwtSecurity.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "course")
@Table(name = "course")
@Data
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;


}
