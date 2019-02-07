package com.biblioteca;

import java.util.List;

// represents a repository of books
interface BookCollection {
    List getAvailableBooks();
    Book getBookWithName(String bookName);
    void checkOutBook(Book book);
    String representation();

}
