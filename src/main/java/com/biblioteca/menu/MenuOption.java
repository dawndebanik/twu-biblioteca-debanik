package com.biblioteca;

import com.biblioteca.io.IODriver;

// represents a point of choice offered to the user
abstract class MenuOption {
    final BookCollection collection;
    final IODriver ioDriver;
    final Formatter formatter;

    MenuOption(BookCollection collection, IODriver ioDriver, Formatter formatter){
        this.collection = collection;
        this.ioDriver = ioDriver;
        this.formatter = formatter;
    }

    abstract void select();
}
