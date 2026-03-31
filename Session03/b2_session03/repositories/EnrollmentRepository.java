package org.example.b1_session03.repositories;

import org.example.b1_session03.models.Enrollment;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class EnrollmentRepository {
    private final List<Enrollment> enrollments = new ArrayList<>(Arrays.asList(
            new Enrollment(1L, "Hoc Vien A", 1L),
            new Enrollment(2L, "Hoc Vien B", 1L)
    ));

    public List<Enrollment> findAll() { return enrollments; }

    public Enrollment findById(Long id) {
        return enrollments.stream().filter(e -> e.getId().equals(id)).findFirst().orElse(null);
    }

    public Enrollment create(Enrollment enrollment) {
        Long newId = enrollments.isEmpty() ? 1L : enrollments.get(enrollments.size() - 1).getId() + 1;
        enrollment.setId(newId);
        enrollments.add(enrollment);
        return enrollment;
    }

    public Enrollment update(Long id, Enrollment data) {
        Enrollment existing = findById(id);
        if (existing != null) {
            existing.setStudentName(data.getStudentName());
            existing.setCourseId(data.getCourseId());
            return existing;
        }
        return null;
    }

    public Enrollment deleteById(Long id) {
        Enrollment existing = findById(id);
        if (existing != null) {
            enrollments.remove(existing);
            return existing;
        }
        return null;
    }
}