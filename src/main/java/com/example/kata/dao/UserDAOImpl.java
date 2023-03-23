package com.example.kata.dao;

import com.example.kata.model.User;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(User updatedUser, Long id) {
        entityManager.merge(updatedUser);
    }

    @Override
    public void deleteUser(Long id) {
        entityManager.remove(getUser(id));
    }

    @Override
    public User getUser(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("From User", User.class).getResultList();
    }
}
