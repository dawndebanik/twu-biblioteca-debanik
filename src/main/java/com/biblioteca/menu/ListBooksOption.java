package com.biblioteca;

import com.biblioteca.io.IODriver;

class ListBooksOption extends MenuOption {

    ListBooksOption(BookCollection collection, IODriver ioDriver, Formatter formatter) {
        super(collection, ioDriver, formatter);
    }

    @Override
    void select() {
        ioDriver.display(formatter.formatBookCollection(collection));
    }
}
