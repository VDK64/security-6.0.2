package com.example.basicAuth.controllers;

import com.example.basicAuth.dto.CourseDto;
import com.example.basicAuth.entities.Course;
import com.example.basicAuth.services.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/course")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping("{id}")
    public ResponseEntity<Course> getCourse(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(courseService.getCourse(id));
    }

    @PostMapping("course")
    public ResponseEntity<Course> saveCourse(@RequestBody CourseDto courseDto) {
        return ResponseEntity.ok(courseService.saveCourse(courseDto));
    }

    @PutMapping("course")
    public ResponseEntity<Course> updateCourse(@RequestBody Course course) {
        return ResponseEntity.ok(courseService.updateCourse(course));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable(name = "id") long id) {
        courseService.deleteCourse(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
