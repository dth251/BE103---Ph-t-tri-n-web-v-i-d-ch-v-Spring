package org.example.b2_session02.controllers;


import lombok.RequiredArgsConstructor;
import org.example.b2_session02.models.Task;
import org.example.b2_session02.services.TaskService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping
    public List<Task> getAllTasks(){
        return taskService.findAllTasks();
    }
}
