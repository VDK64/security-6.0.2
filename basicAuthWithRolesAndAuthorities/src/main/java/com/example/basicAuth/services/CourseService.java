package com.example.basicAuth.services;

import com.example.basicAuth.dto.CourseDto;
import com.example.basicAuth.entities.Course;
import com.example.basicAuth.errors.CourseNotFoundException;
import com.example.basicAuth.repositories.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    public Course saveCourse(CourseDto courseDto) {
        Course course = new Course();
        course.setHours(courseDto.hours());
        course.setName(courseDto.name());
        return courseRepository.save(course);
    }

    public void deleteCourse(long id) {
        courseRepository.deleteById(id);
    }

    public Course updateCourse(Course course) {
        return courseRepository.save(course);
    }

    public Course getCourse(long id) {
        return courseRepository.findById(id).orElseThrow(() -> new CourseNotFoundException("Course with id " + id + " not found"));
    }

}
