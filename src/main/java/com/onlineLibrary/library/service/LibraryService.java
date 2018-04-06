package com.onlineLibrary.library.service;

import com.onlineLibrary.library.dao.interfaces.BookDAO;
import com.onlineLibrary.library.entities.Book;
import com.onlineLibrary.library.entities.Genre;
import com.onlineLibrary.library.entities.Writer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.onlineLibrary.library.entities.Publisher;

import java.util.List;

@Component("libraryService")
@Scope("singleton")
public class LibraryService {

    private List<Book> books;
    private BookDAO bookDAO;
    private Genre genre;
    private int bookId;
    private Writer writer;
    private Publisher publisher;

    @Autowired
    public void setBookDAO(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public void setWriter(Writer writer) {
        this.writer = writer;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public List<Book> getBooks(){
        if(books == null){
            books = bookDAO.getAllBooks();
        }
        return books;
    }

    public int deleteBookById(){
        return bookDAO.deleteBookById(bookId);
    }

    public void findBookByGenre(){
        books = bookDAO.getBooksByGenre(genre);
    }

    public void findBookByWriter(){
        books = bookDAO.getBooksByWriter(writer);
    }

    public void findBookByPublisher(){
        books = bookDAO.getBooksByPublisher(publisher);
    }
}
