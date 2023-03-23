package com.example.kata.service;

import com.example.kata.dao.UserDAO;
import com.example.kata.model.User;
import org.springframework.stereotype.Service;



import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UserDAO userDAO;


    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    @Transactional
    public void addUser(User user) {
        userDAO.addUser(user);
    }

    @Override
    @Transactional
    public void updateUser(User updatedUser, Long id) {
        userDAO.updateUser(updatedUser, id);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        userDAO.deleteUser(id);
    }

    @Override
    @Transactional
    public User getUser(Long id) {
        return userDAO.getUser(id);
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }
}
