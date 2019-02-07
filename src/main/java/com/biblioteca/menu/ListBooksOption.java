package com.biblioteca.menu;

import com.biblioteca.BookCollection;
import com.biblioteca.Formatter;
import com.biblioteca.io.IODriver;

public class ListBooksOption extends MenuOption {

    public ListBooksOption(BookCollection collection, IODriver ioDriver, Formatter formatter) {
        super(collection, ioDriver, formatter);
    }

    @Override
    public void select() {
        ioDriver.display(formatter.formatBookCollection(collection));
    }
}