package com.example.kata.dao;

import com.example.kata.model.User;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Transactional
    public void updateUser(User updatedUser, Long id) {
        entityManager.merge(updatedUser);
    }

    @Transactional
    public void deleteUser(Long id) {
        entityManager.remove(getUser(id));
    }

    @Transactional
    public User getUser(Long id) {
        return entityManager.find(User.class, id);
    }

    @Transactional
    public List<User> getAllUsers() {
        return entityManager.createQuery("From User", User.class).getResultList();
    }
}
