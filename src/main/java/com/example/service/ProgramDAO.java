package com.example.service;

import com.example.entity.Program;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProgramDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public ProgramDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    // 1. Find all programs
    public List<Program> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Program", Program.class).list();
        }
    }
    
 // Find a program by ID
    public Program findById(long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Program.class, id);
        }
    }

    // 2. Find a program by name
    public Program findByName(String programName) {
        try (Session session = sessionFactory.openSession()) {
            String query = "FROM Program WHERE programName = :programName";
            return session.createQuery(query, Program.class)
                    .setParameter("programName", programName)
                    .uniqueResult();
        }
    }

    // 3. Save a new program
    public void save(Program program) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(program);
            session.getTransaction().commit();
        }
    }

    // 4. Update an existing program
    public void update(Program program) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(program);
            session.getTransaction().commit();
        }
    }


    // Delete a program by ID
    public void deleteById(long id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Program program = session.get(Program.class, id);
            if (program != null) {
                session.delete(program);
            }
            session.getTransaction().commit();
        }
    }

    // 6. Search for programs by name (case-insensitive partial match)
    public List<Program> searchByName(String partialName) {
        try (Session session = sessionFactory.openSession()) {
            String query = "FROM Program WHERE LOWER(programName) LIKE :partialName";
            return session.createQuery(query, Program.class)
                    .setParameter("partialName", "%" + partialName.toLowerCase() + "%")
                    .list();
        }
    }
}
