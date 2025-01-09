package com.example.service;

import com.example.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Save a new user to the database.
     *
     * @param user The user to save.
     */
    public void save(User user) {
        entityManager.persist(user);
    }

    /**
     * Update an existing user in the database.
     *
     * @param user The user to update.
     */
    public void update(User user) {
        entityManager.merge(user);
    }

    /**
     * Delete a user by their ID.
     *
     * @param id The ID of the user to delete.
     */
    public void deleteById(int id) {
        User user = findById(id);
        if (user != null) {
            entityManager.remove(user);
        }
    }

    /**
     * Find a user by their ID.
     *
     * @param id The ID of the user.
     * @return The user if found, otherwise null.
     */
    public User findById(int id) {
        return entityManager.find(User.class, id);
    }

    /**
     * Find a user by their username.
     *
     * @param username The username of the user.
     * @return The user if found, otherwise null.
     */
    public User findByUsername(String username) {
        String query = "FROM User WHERE username = :username";
        List<User> result = entityManager.createQuery(query, User.class)
                .setParameter("username", username)
                .getResultList();

        return result.isEmpty() ? null : result.get(0);
    }

    /**
     * Retrieve all users from the database.
     *
     * @return A list of all users.
     */
    public List<User> findAll() {
        String query = "FROM User";
        return entityManager.createQuery(query, User.class).getResultList();
    }
}
