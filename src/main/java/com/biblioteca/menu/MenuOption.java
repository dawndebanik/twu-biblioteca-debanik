package com.biblioteca.menu;

import com.biblioteca.BookCollection;
import com.biblioteca.format.Formatter;
import com.biblioteca.io.IODriver;

// represents a point of choice offered to the user
public abstract class MenuOption {
    final BookCollection collection;
    final IODriver ioDriver;
    final Formatter formatter;

    MenuOption(BookCollection collection, IODriver ioDriver, Formatter formatter){
        this.collection = collection;
        this.ioDriver = ioDriver;
        this.formatter = formatter;
    }

    public abstract void select();
}
