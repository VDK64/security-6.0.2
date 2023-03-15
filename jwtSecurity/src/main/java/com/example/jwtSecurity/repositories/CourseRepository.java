package com.example.jwtSecurity.repositories;

import com.example.jwtSecurity.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {

    Optional<Course> findByName(String name);

    @Transactional
    void deleteByName(String name);

}
