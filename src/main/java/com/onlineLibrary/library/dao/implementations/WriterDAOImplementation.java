package com.onlineLibrary.library.dao.implementations;

import com.onlineLibrary.library.dao.interfaces.WriterDAO;
import com.onlineLibrary.library.entities.Writer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class WriterDAOImplementation implements WriterDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private List<Writer> writers;

    @Transactional
    public List<Writer> getAllWriters() {
        Session session = sessionFactory.getCurrentSession();
        writers = session.createQuery("FROM Writer").list();
        return writers;
    }
}
