package org.example.b1_session03.services;

import org.example.b1_session03.models.Enrollment;
import org.example.b1_session03.repositories.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentService {
    private final EnrollmentRepository repository;

    @Autowired
    public EnrollmentService(EnrollmentRepository repository) {
        this.repository = repository;
    }

    public List<Enrollment> getAll() {
        return repository.findAll();
    }

    public Enrollment getById(Long id) {
        return repository.findById(id);
    }

    public Enrollment create(Enrollment enrollment) {
        return repository.create(enrollment);
    }

    public Enrollment update(Long id, Enrollment enrollment) {
        return repository.update(id, enrollment);
    }

    public Enrollment delete(Long id) {
        return repository.deleteById(id);
    }
}