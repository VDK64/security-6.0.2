package com.example.basicAuth.controllers;

import com.example.basicAuth.dto.CourseDto;
import com.example.basicAuth.entities.Course;
import com.example.basicAuth.services.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/course")
@RequiredArgsConstructor
@PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
public class CourseController {

    private final CourseService courseService;

    @GetMapping("{id}")
    @PreAuthorize("hasAnyAuthority('course:read', 'course:write')")
    public ResponseEntity<Course> getCourse(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(courseService.getCourse(id));
    }

    @PostMapping("course")
    @PreAuthorize("hasAuthority('course:write')")
    public ResponseEntity<Course> saveCourse(@RequestBody CourseDto courseDto) {
        return ResponseEntity.ok(courseService.saveCourse(courseDto));
    }

    @PutMapping("course")
    @PreAuthorize("hasAuthority('course:write')")
    public ResponseEntity<Course> updateCourse(@RequestBody Course course) {
        return ResponseEntity.ok(courseService.updateCourse(course));
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasAuthority('course:write')")
    public ResponseEntity<Void> deleteCourse(@PathVariable(name = "id") long id) {
        courseService.deleteCourse(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
