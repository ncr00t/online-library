package com.onlineLibrary.library.dao.implementations;

import com.onlineLibrary.library.dao.interfaces.BookDAO;
import com.onlineLibrary.library.entities.Book;
import com.onlineLibrary.library.entities.Genre;
import com.onlineLibrary.library.entities.Publisher;
import com.onlineLibrary.library.entities.Writer;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

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


    public List<Book> getBooksByWriter(Writer writer) {
//        Session session = sessionFactory.getCurrentSession();
//        session.beginTransaction();
        books = writer.getBooks();
        return books;
    }

    public List<Book> getBooksByName(String bookName) {
        return null;
    }


    public List<Book> getBooksByGenre(Genre genre) {
       books = genre.getBooks();
        return books;
    }

    public List<Book> getBooksByPublisher(Publisher publisher){
        books = publisher.getBooks();
        return books;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
    }

    @Transactional
    public Object getFieldValueById(int id, String fieldName) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Book as b WHERE b.id = :id");
        query.setParameter("id",id);
//        query.setParameter("fieldName", fieldName);
        books = query.list();
        return books;
    }

    @Transactional
    @Override
    public int deleteBookById(int bookId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("DELETE Book  WHERE  id = :id");
        query.setParameter("id",bookId);
        return bookId;
    }
}
