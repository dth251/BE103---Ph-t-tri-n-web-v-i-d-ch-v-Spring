package org.example.b1_session03.controllers;

import org.example.b1_session03.models.Instructor;
import org.example.b1_session03.services.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/instructors")
public class InstructorController {
    private final InstructorService service;

    @Autowired
    public InstructorController(InstructorService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Instructor>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Instructor> getById(@PathVariable Long id) {
        Instructor item = service.getById(id);
        return item != null ? ResponseEntity.ok(item) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Instructor> create(@RequestBody Instructor instructor) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(instructor));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Instructor> update(@PathVariable Long id, @RequestBody Instructor instructor) {
        Instructor updated = service.update(id, instructor);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Instructor> delete(@PathVariable Long id) {
        Instructor deleted = service.delete(id);
        return deleted != null ? ResponseEntity.ok(deleted) : ResponseEntity.notFound().build();
    }
}