package com.onlineLibrary.library.dao.implementations;

import com.onlineLibrary.library.dao.interfaces.BookDAO;
import com.onlineLibrary.library.entities.Book;
import com.onlineLibrary.library.entities.Genre;
import com.onlineLibrary.library.entities.Publisher;
import com.onlineLibrary.library.entities.Writer;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public class BookDAOImplementation implements BookDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private List<Book> books;

    public void setSessionFactory(SessionFactory sessionFactory) {
    }

    @Transactional
    public List<Book> getAllBooks() {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        books = session.createQuery("FROM Book").list();
        transaction.commit();
        return books;
    }

    public List<Book> getBooksByWriter(Writer writer) {
        books = writer.getBooks();
        return books;
    }

    @Transactional
    public List<Book> getBooksByName(String bookName) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("FROM Book as b WHERE b.name = :name");
        query.setParameter("name", bookName);
        books = query.list();
        transaction.commit();
        return books;
    }

    public List<Book> getBooksByGenre(Genre genre) {
       books = genre.getBooks();
        return books;
    }

    public List<Book> getBooksByPublisher(Publisher publisher){
        books = publisher.getBooks();
        return books;
    }

    @Transactional
    public Object getFieldValueById(int id, String fieldName) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Book as b WHERE b.id = :id");
        query.setParameter("id",id);
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
