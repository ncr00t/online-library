package com.onlineLibrary.library.dao.implementations;

import com.onlineLibrary.library.dao.interfaces.PublisherDAO;
import com.onlineLibrary.library.entities.Publisher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class PublisherDAOImplementation implements PublisherDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private List<Publisher> publishers;

    @Transactional
    public List<Publisher> getAllPublishers() {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        publishers = session.createQuery("FROM Publisher ").list();
        transaction.commit();
        return publishers;
    }
}
