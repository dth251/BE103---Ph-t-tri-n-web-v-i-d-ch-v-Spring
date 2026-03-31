package org.example.b1_session03.repositories;

import org.example.b1_session03.models.Enrollment;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class EnrollmentRepository {
    private final List<Enrollment> enrollments = new ArrayList<>(Arrays.asList(
            new Enrollment(1L, "Le Van C", 1L),
            new Enrollment(2L, "Pham Thi D", 1L),
            new Enrollment(3L, "Hoang Van E", 2L)
    ));

    public List<Enrollment> findAll() {
        return enrollments;
    }
}