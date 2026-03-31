package org.example.b2_session02.services;

import lombok.RequiredArgsConstructor;
import org.example.b2_session02.models.User;
import org.example.b2_session02.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> findAllUsers(){
        return userRepository.findAll();
    }
}
