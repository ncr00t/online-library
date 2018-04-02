package com.onlineLibrary.library.service;

import com.onlineLibrary.library.dao.interfaces.BookDAO;
import com.onlineLibrary.library.entities.Book;
import com.onlineLibrary.library.entities.Genre;
import com.onlineLibrary.library.entities.Publisher;
import com.onlineLibrary.library.entities.Writer;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class LibraryService {

    private BookDAO bookDAO;

    private Genre genre;

    private int id;

    private Writer writer;

    private Publisher publisher;

    @Autowired
    public void setBookDAO(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setWriter(Writer writer) {
        this.writer = writer;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public List<Book> getBooks(){
        return bookDAO.getAllBooks();
    }

    public int deleteBookById(){
        return bookDAO.deleteBookById(id);
    }

    public List<Book> findBookByGenre(){
        return bookDAO.getBooksByGenre(genre);
    }

    public List<Book> findBookByWriter(){
        return bookDAO.getBooksByWriter(writer);
    }

    public List<Book> findBookByPublisher(){
        return bookDAO.getBooksByPublisher(publisher);
    }
}
