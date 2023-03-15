package com.example.jwtSecurity.services;

import com.example.jwtSecurity.dto.CourseDto;
import com.example.jwtSecurity.entity.Course;
import com.example.jwtSecurity.exceptions.CourseNotFoundException;
import com.example.jwtSecurity.repositories.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    public Course create(CourseDto courseDto) {
        Course course = new Course();
        course.setName(courseDto.name());
        return courseRepository.save(course);
    }

    public Course update(CourseDto courseDto) {
        Course course = courseRepository.findByName(courseDto.name())
                .orElseThrow(() -> new CourseNotFoundException(String.format("Course %s not found", courseDto.name())));
        course.setName(courseDto.name());
        return courseRepository.save(course);
    }

    public void delete(CourseDto courseDto) {
        courseRepository.deleteByName(courseDto.name());
    }

    public List<Course> getCourses() {
        return  courseRepository.findAll();
    }

}
