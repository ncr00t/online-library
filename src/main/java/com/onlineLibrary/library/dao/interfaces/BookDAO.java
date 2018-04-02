package com.onlineLibrary.library.dao.interfaces;

import com.onlineLibrary.library.entities.Book;
import com.onlineLibrary.library.entities.Genre;
import com.onlineLibrary.library.entities.Publisher;
import com.onlineLibrary.library.entities.Writer;

import java.util.List;
import java.util.Set;

public interface BookDAO {
    List<Book> getAllBooks();
    List<Book> getBooksByWriter(Writer writer);
    List<Book> getBooksByName(String bookName);
    List<Book> getBooksByGenre(Genre genre);
    List<Book> getBooksByPublisher(Publisher publisher);
    int deleteBookById(int bookId);
    Object getFieldValueById(int id, String fieldName);
}
