package org.example.session04.repository;

import org.example.session04.entity.StudentEnrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentEnrollmentRepository extends JpaRepository<StudentEnrollment,Integer> {
}
