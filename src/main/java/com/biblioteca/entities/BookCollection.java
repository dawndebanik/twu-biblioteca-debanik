package com.biblioteca.entities;

import com.biblioteca.BookNotAvailableException;

import java.util.List;

// represents a repository of books
public interface BookCollection {
    List<Book> getAvailableBooks();
    void removeBook(String bookName) throws BookNotAvailableException;
}