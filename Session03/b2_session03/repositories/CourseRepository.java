package org.example.b1_session03.repositories;

import org.example.b1_session03.models.Course;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class CourseRepository {
    private final List<Course> courses = new ArrayList<>(Arrays.asList(
            new Course(1L, "Spring Boot Core", "ACTIVE", 1L),
            new Course(2L, "React JS", "DRAFT", 2L)
    ));

    public List<Course> findAll() { return courses; }

    public Course findById(Long id) {
        return courses.stream().filter(c -> c.getId().equals(id)).findFirst().orElse(null);
    }

    public Course create(Course course) {
        Long newId = courses.isEmpty() ? 1L : courses.get(courses.size() - 1).getId() + 1;
        course.setId(newId);
        courses.add(course);
        return course;
    }

    public Course update(Long id, Course data) {
        Course existing = findById(id);
        if (existing != null) {
            existing.setTitle(data.getTitle());
            existing.setStatus(data.getStatus());
            existing.setInstructorId(data.getInstructorId());
            return existing;
        }
        return null;
    }

    public Course deleteById(Long id) {
        Course existing = findById(id);
        if (existing != null) {
            courses.remove(existing);
            return existing;
        }
        return null;
    }
}