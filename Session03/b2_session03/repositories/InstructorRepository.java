package org.example.b1_session03.repositories;

import org.example.b1_session03.models.Instructor;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class InstructorRepository {
    private final List<Instructor> instructors = new ArrayList<>(Arrays.asList(
            new Instructor(1L, "Nguyen Van A", "a@example.com"),
            new Instructor(2L, "Tran Thi B", "b@example.com")
    ));

    public List<Instructor> findAll() { return instructors; }

    public Instructor findById(Long id) {
        return instructors.stream().filter(i -> i.getId().equals(id)).findFirst().orElse(null);
    }

    public Instructor create(Instructor instructor) {
        Long newId = instructors.isEmpty() ? 1L : instructors.get(instructors.size() - 1).getId() + 1;
        instructor.setId(newId);
        instructors.add(instructor);
        return instructor;
    }

    public Instructor update(Long id, Instructor data) {
        Instructor existing = findById(id);
        if (existing != null) {
            existing.setName(data.getName());
            existing.setEmail(data.getEmail());
            return existing;
        }
        return null;
    }

    public Instructor deleteById(Long id) {
        Instructor existing = findById(id);
        if (existing != null) {
            instructors.remove(existing);
            return existing;
        }
        return null;
    }
}