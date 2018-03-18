package com.onlineLibrary.library.dao.implementations;

import com.onlineLibrary.library.dao.interfaces.BookDAO;
import com.onlineLibrary.library.entities.Genre;
import com.onlineLibrary.library.entities.Writer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Book;
import java.util.List;

@Repository
public class BookDAOImplementation implements BookDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private List<Book> books;

    @Transactional
    public List<Book> getAllBooks() {
        Session session = sessionFactory.getCurrentSession();
        books = session.createQuery("FROM Book").list();
        return books;
    }

    public List<Book> getBooksByWriterName(Writer writer) {
        return null;
    }

    public List<Book> getBooksByName(String bookName) {
        return null;
    }

    public List<Book> getBooksByGenre(Genre genre) {
        return null;
    }

    public List<Book> getBooksByFirstLetter(Character firstLetter) {
        return null;
    }
}
