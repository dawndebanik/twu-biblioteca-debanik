package com.biblioteca;

import java.util.List;

// represents a repository of books
interface BookCollection {
    List<Book> getAvailableBooks();
    void checkOutBook(String bookName) throws BookNotAvailableException;
    String representation();

}
