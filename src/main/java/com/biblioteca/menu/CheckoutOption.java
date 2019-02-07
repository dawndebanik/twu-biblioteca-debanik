package com.biblioteca;

import com.biblioteca.io.IODriver;

class CheckoutOption extends MenuOption {
    private static final String AVAILABLE_BOOKS_HEADER = "Available books:";

    CheckoutOption(BookCollection collection, IODriver ioDriver, Formatter formatter) {
        super(collection, ioDriver, formatter);
    }

    @Override
    void select() {
        ioDriver.display(formatter.formatBookCollection(collection));
        String bookNameChoice = ioDriver.readInput();
        try {
            collection.removeBook(bookNameChoice);
            ioDriver.display("Thank you! Enjoy the book.");
        } catch (BookNotAvailableException exception) {
            ioDriver.display("That book is not available.");
        }
    }
}
