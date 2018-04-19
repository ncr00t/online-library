package com.onlineLibrary.library.dao.implementations;

import com.onlineLibrary.library.dao.interfaces.GenreDAO;
import com.onlineLibrary.library.entities.Genre;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public class GenreDAOImplementation implements GenreDAO {

    @Autowired
    private SessionFactory sessionFactory;
    private List<Genre> genres;

    @Transactional
    public List<Genre> getAllGenres() {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        genres = session.createQuery("FROM Genre").list();
        transaction.commit();
        return genres;
    }
}
