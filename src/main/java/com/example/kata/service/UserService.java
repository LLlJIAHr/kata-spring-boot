package com.example.kata.service;



import com.example.kata.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    void updateUser(User updatedUser, Long id);
    void deleteUser(Long id);
    User getUser(Long id);
    List<User> getAllUsers();
}
