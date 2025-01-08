package com.example.service;

import com.example.entity.Crew;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CrewDAO {

    @PersistenceContext
    private EntityManager entityManager;

    // Save or update a Crew entity
    public Crew saveOrUpdate(Crew crew) {
        if (crew.getId() == 0) {
            entityManager.persist(crew);
        } else {
            entityManager.merge(crew);
        }
        return crew;
    }

    // Retrieve all Crew entities
    public List<Crew> findAll() {
        return entityManager.createQuery("FROM Crew", Crew.class).getResultList();
    }

    // Retrieve a Crew entity by ID
    public Crew findById(int id) {
        return entityManager.find(Crew.class, id);
    }

    // Delete a Crew entity by ID
    public void deleteById(int id) {
        Crew crew = findById(id);
        if (crew != null) {
            entityManager.remove(crew);
        }
    }
    
    // Find crews by status
    public List<Crew> findByStatus(String status) {
        return entityManager.createQuery("FROM Crew WHERE status = :status", Crew.class)
                            .setParameter("status", status)
                            .getResultList();
    }

    // Update crew status
    public void updateStatus(int id, String status) {
        Crew crew = findById(id);
        if (crew != null) {
            crew.setStatus(status);
            entityManager.merge(crew);
        }
    }

}
