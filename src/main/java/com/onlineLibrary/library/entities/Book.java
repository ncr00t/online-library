package com.onlineLibrary.library.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class  Book {
    private int id;
    private String isbn;
    private String name;
    private String languageOfPublish;
    private int pageCount;
    private int yearOfPublish;
    private byte[] content;
    private byte[] image;
    private String description;
    private int genreId;
    private int publisherId;
    private Genre genre;
    private Publisher publisher;

    private List<Writer> writers = new ArrayList<Writer>();

    public List<Writer> getWriters() {
        return writers;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public void setWriters(List<Writer> writers) {
        this.writers = writers;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguageOfPublish() {
        return languageOfPublish;
    }

    public void setLanguageOfPublish(String languageOfPublish) {
        this.languageOfPublish = languageOfPublish;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getYearOfPublish() {
        return yearOfPublish;
    }

    public void setYearOfPublish(int yearOfPublish) {
        this.yearOfPublish = yearOfPublish;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (id != book.id) return false;
        if (pageCount != book.pageCount) return false;
        if (yearOfPublish != book.yearOfPublish) return false;
        if (genreId != book.genreId) return false;
        if (publisherId != book.publisherId) return false;
        if (isbn != null ? !isbn.equals(book.isbn) : book.isbn != null) return false;
        if (name != null ? !name.equals(book.name) : book.name != null) return false;
        if (languageOfPublish != null ? !languageOfPublish.equals(book.languageOfPublish) : book.languageOfPublish != null)
            return false;
        if (!Arrays.equals(content, book.content)) return false;
        if (!Arrays.equals(image, book.image)) return false;
        if (description != null ? !description.equals(book.description) : book.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (isbn != null ? isbn.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (languageOfPublish != null ? languageOfPublish.hashCode() : 0);
        result = 31 * result + pageCount;
        result = 31 * result + yearOfPublish;
        result = 31 * result + Arrays.hashCode(content);
        result = 31 * result + Arrays.hashCode(image);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + genreId;
        result = 31 * result + publisherId;
        return result;
    }
}
