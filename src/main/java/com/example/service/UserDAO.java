package com.example.service;

import com.example.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void registerUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.save(user);
        } catch (Exception e) {
            System.out.println("Error saving user: " + e.getMessage());
            throw e; // Re-throw to let the transaction roll back
        }
    }
    public User getUserByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        try {
            return session.createQuery("FROM User WHERE username = :username", User.class)
                    .setParameter("username", username)
                    .uniqueResult();
        } catch (Exception e) {
            return null;
        }
    }
}
