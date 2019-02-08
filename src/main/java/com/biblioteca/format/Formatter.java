package com.biblioteca.format;

import com.biblioteca.entities.Book;
import com.biblioteca.entities.BookCollection;

public interface Formatter {
    String formatBookCollection(BookCollection collection);
    String formatBook(Book book);
}
