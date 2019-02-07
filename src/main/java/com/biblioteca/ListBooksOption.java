package com.biblioteca;

import com.biblioteca.io.IODriver;

public class ListBooksOption extends MenuOption {
    private static final String AVAILABLE_BOOKS_HEADER = "Available books:";

    ListBooksOption(BookCollection collection, IODriver ioDriver, Formatter formatter) {
        super(collection, ioDriver, formatter);
    }

    @Override
    void onSelect() {
        ioDriver.display(AVAILABLE_BOOKS_HEADER);
        ioDriver.display(formatter.formatBookCollection(collection));
    }
}
