package com.onlineLibrary.library.dao.interfaces;

import com.onlineLibrary.library.entities.Genre;
import com.onlineLibrary.library.entities.Writer;

import java.awt.print.Book;
import java.util.List;

public interface BookDAO {
    List<Book> getAllBooks();
    List<Book> getBooksByWriterName(Writer writer);
    List<Book> getBooksByName(String bookName);
    List<Book> getBooksByGenre(Genre genre);
    List<Book> getBooksByFirstLetter(Character firstLetter);
}
