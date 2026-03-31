package org.example.b2_session02.services;


import lombok.RequiredArgsConstructor;
import org.example.b2_session02.models.Task;
import org.example.b2_session02.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    public List<Task> findAllTasks(){
        return taskRepository.findAll();
    }
}
