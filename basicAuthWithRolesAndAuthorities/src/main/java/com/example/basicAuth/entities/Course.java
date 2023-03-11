package com.example.basicAuth.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity(name = "course")
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    private int hours;

}
