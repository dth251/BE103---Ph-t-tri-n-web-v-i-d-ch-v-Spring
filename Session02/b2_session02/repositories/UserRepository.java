package org.example.b2_session02.repositories;

import org.example.b2_session02.models.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private final List<User> users = new ArrayList<>();

    public UserRepository(){
        users.add(new User(1L, "admin_user", "admin@example.com", "ADMIN"));
        users.add(new User(2L, "dev_user1", "dev1@example.com", "USER"));
        users.add(new User(3L, "dev_user2", "dev2@example.com", "USER"));
    }
    public List<User> findAll(){
        return users;
    }
}
