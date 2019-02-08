package com.biblioteca.format;

import com.biblioteca.Book;
import com.biblioteca.BookCollection;

public interface Formatter {
    String formatBookCollection(BookCollection collection);
    String formatBook(Book book);
}
