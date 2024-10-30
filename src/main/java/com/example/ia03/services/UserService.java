package com.example.ia03.services;
import java.util.List;

import com.example.ia03.models.User;

public interface UserService {
    public List<User> findAll();
    public User findByEmail(String username);
    public User saveUser(User user);
}
