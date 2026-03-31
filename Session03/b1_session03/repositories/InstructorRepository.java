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

    public List<Instructor> findAll() {
        return instructors;
    }
}