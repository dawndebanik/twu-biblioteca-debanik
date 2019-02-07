package com.biblioteca;

import java.util.List;

// represents a repository of books
interface BookCollection {
    List<Book> getAvailableBooks();
    void removeBook(String bookName) throws BookNotAvailableException;
}
