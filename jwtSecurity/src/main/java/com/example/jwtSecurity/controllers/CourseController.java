package com.example.jwtSecurity.controllers;

import com.example.jwtSecurity.dto.CourseDto;
import com.example.jwtSecurity.entity.Course;
import com.example.jwtSecurity.services.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("course")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @PostMapping
    public ResponseEntity<Course> create(Authentication authentication, @RequestBody CourseDto courseDto) {
        return new ResponseEntity<Course>(courseService.create(courseDto), HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<List<Course>> getCourses() {
        return new ResponseEntity<List<Course>>(courseService.getCourses(), HttpStatus.OK);
    }


    @PutMapping
    public ResponseEntity<Course> updateCourse(@RequestBody CourseDto courseDto) {
        return new ResponseEntity<Course>(courseService.update(courseDto), HttpStatus.OK);
    }


    @DeleteMapping
    public ResponseEntity<Void> deleteCourse(@RequestBody CourseDto courseDto) {
        courseService.delete(courseDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
