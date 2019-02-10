package com.biblioteca.format;

import com.biblioteca.entities.Book;
import com.biblioteca.entities.BookCollection;
import com.biblioteca.entities.ItemCollection;
import com.biblioteca.menu.Menu;

// represents a contract where an entity shows data
// in a particular way to the user
public interface Formatter {
    String format(ItemCollection collection);
    String format(Book book);
    String format(String message);
    String format(Menu menu);
}
