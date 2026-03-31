package org.example.b2_session02.controllers;


import lombok.RequiredArgsConstructor;
import org.example.b2_session02.models.Task;
import org.example.b2_session02.models.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserController userController;

    @GetMapping
    public List<Task> findAllTasks(){
        return userController.findAllTasks();
    }
}
