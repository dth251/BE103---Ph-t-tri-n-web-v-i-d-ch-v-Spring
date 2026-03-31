package org.example.b1_session03.repositories;

import org.example.b1_session03.models.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class CourseRepository {
    private final List<Course> courses = new ArrayList<>(Arrays.asList(
            new Course(1L, "Spring Boot Cơ bản", "ACTIVE", 1L),
            new Course(2L, "ReactJS Nâng cao", "DRAFT", 2L)
    ));

    public List<Course> findAll() {
        return courses;
    }
}