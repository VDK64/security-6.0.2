package com.example.basicAuth.repositories;

import com.example.basicAuth.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
