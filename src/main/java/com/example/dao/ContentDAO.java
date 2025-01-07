package com.example.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import com.example.model.Content;

@Repository
public class ContentDAO {

    @PersistenceContext
    private EntityManager entityManager;

    // Fetch all content
    public List<Content> getAllContent() {
        String query = "FROM Content";
        return entityManager.createQuery(query, Content.class).getResultList();
    }

    // Fetch content by ID
    public Content getContentById(String contentID) {
        return entityManager.find(Content.class, contentID);
    }

    // Save or update content
    public void saveOrUpdateContent(Content content) {
        entityManager.merge(content);
    }

    // Delete content by ID
    public void deleteContent(String contentID) {
        Content content = getContentById(contentID);
        if (content != null) {
            entityManager.remove(content);
        }
    }
}
