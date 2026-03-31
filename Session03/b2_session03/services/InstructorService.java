package org.example.b1_session03.services;

import org.example.b1_session03.models.Instructor;
import org.example.b1_session03.repositories.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InstructorService {
    private final InstructorRepository repository;

    @Autowired
    public InstructorService(InstructorRepository repository) {
        this.repository = repository;
    }

    public List<Instructor> getAll() { return repository.findAll(); }
    public Instructor getById(Long id) { return repository.findById(id); }
    public Instructor create(Instructor instructor) { return repository.create(instructor); }
    public Instructor update(Long id, Instructor instructor) { return repository.update(id, instructor); }
    public Instructor delete(Long id) { return repository.deleteById(id); }
}