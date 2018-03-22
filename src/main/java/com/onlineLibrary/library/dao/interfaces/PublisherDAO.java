package com.onlineLibrary.library.dao.interfaces;

import com.onlineLibrary.library.entities.Book;
import com.onlineLibrary.library.entities.Publisher;

import java.util.List;

public interface PublisherDAO {
    List<Publisher> getAllPublishers();
}
