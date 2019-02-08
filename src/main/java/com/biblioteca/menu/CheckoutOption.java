package com.biblioteca.menu;

import com.biblioteca.BookCollection;
import com.biblioteca.BookNotAvailableException;
import com.biblioteca.format.Formatter;
import com.biblioteca.io.IODriver;

public class CheckoutOption extends MenuOption {
    private static final String AVAILABLE_BOOKS_HEADER = "Available books:";

    public CheckoutOption(BookCollection collection, IODriver ioDriver, Formatter formatter) {
        super(collection, ioDriver, formatter);
    }

    @Override
    public void select() {
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
