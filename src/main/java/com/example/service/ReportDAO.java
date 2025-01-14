package com.example.service;

import com.example.entity.Program;
import com.example.entity.Report;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReportDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public ReportDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    // Find all reports
    public List<Report> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Report", Report.class).list();
        }
    }

    // Save a new report
    public void save(Report report) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(report);
            session.getTransaction().commit();
        }
    }
    
    public Report findById(long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Report.class, id);
        }
    }
}
