package com.biblioteca.menu;

import com.biblioteca.BookNotAvailableException;
import com.biblioteca.UIDriver;
import com.biblioteca.entities.BookCollection;

public class CheckoutOption extends MenuOption {
    private static final String AVAILABLE_BOOKS_HEADER = "Available books:";
    private static final String SUCCESSFUL_CHECKOUT_MESSAGE = "Thank you! Enjoy the book.";
    private static final String UNSUCCESSFUL_CHECKOUT_MESSAGE = "That book is not available.";

    public CheckoutOption(String nameOnScreen, BookCollection collection, UIDriver uiDriver) {
        super(nameOnScreen, collection, uiDriver);
    }

    CheckoutOption(String nameOnScreen, BookCollection collection) {
        super(nameOnScreen, collection);
    }

    public CheckoutOption(String nameOnScreen) {
        super(nameOnScreen);
    }


    @Override
    public void select() {
        uiDriver.show(collection);
        String bookNameChoice =  uiDriver.readInput();

        try {
            collection.removeBook(bookNameChoice);
            uiDriver.show(SUCCESSFUL_CHECKOUT_MESSAGE);
        } catch (BookNotAvailableException exception) {
            uiDriver.show(UNSUCCESSFUL_CHECKOUT_MESSAGE);
        }
    }
}
