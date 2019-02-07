package com.biblioteca;

import java.util.List;

// represents a repository of books
interface BookCollection {
    List getAvailableBooks();
    Book getBookWithIndex(int index);
    void checkOutBook(Book book);
    String representation();

}
