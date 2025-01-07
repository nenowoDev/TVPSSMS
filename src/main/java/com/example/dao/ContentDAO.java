package com.example.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.model.Content;

@Repository
public class ContentDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public ContentDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    // 1 - Get all content
    public List<Content> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Content", Content.class).list();
        }
    }

    // 2 - Get content by ID
    public Content findById(String contentID) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Content.class, contentID);
        }
    }

    // 3 - Create a new content
    public void save(Content content) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(content);
            session.getTransaction().commit();
        }
    }

    // 4 - Update an existing content
    public void update(Content content) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(content);
            session.getTransaction().commit();
        }
    }

    // 5 - Delete content by ID
    public void deleteById(String contentID) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Content content = session.get(Content.class, contentID);
            if (content != null) {
                session.delete(content);
            }
            session.getTransaction().commit();
        }
    }

    // 6 - Search for content by title
    public List<Content> searchByTitle(String title) {
        try (Session session = sessionFactory.openSession()) {
            String query = "FROM Content WHERE LOWER(contentTitle) LIKE :title";
            return session.createQuery(query, Content.class)
                          .setParameter("title", "%" + title.toLowerCase() + "%")
                          .list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
