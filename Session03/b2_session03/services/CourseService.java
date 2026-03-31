package org.example.b1_session03.services;

import org.example.b1_session03.models.Course;
import org.example.b1_session03.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    private final CourseRepository repository;

    @Autowired
    public CourseService(CourseRepository repository) {
        this.repository = repository;
    }

    public List<Course> getAll() {
        return repository.findAll();
    }

    public Course getById(Long id) {
        return repository.findById(id);
    }

    public Course create(Course course) {
        return repository.create(course);
    }

    public Course update(Long id, Course course) {
        return repository.update(id, course);
    }

    public Course delete(Long id) {
        return repository.deleteById(id);
    }
}