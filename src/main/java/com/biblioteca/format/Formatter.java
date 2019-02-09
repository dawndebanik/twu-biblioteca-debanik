package com.biblioteca.format;

import com.biblioteca.entities.Book;
import com.biblioteca.entities.BookCollection;
import com.biblioteca.menu.Menu;

// represents a contract where an entity
public interface Formatter {
    String format(BookCollection collection);
    String format(Book book);
    String format(String message);
    String format(Menu menu);
}
