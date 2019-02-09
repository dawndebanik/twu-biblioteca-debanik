package com.biblioteca.menu;

import com.biblioteca.BookNotAvailableException;
import com.biblioteca.UIDriver;
import com.biblioteca.entities.BookCollection;

public class CheckoutOption extends MenuOption {
    private static final String AVAILABLE_BOOKS_HEADER = "Available books:";
    public static final String SUCCESSFUL_CHECKOUT_MESSAGE = "Thank you! Enjoy the book.";
    public static final String UNSUCCESSFUL_CHECKOUT_MESSAGE = "That book is not available.";

    public CheckoutOption(String nameOnScreen, BookCollection collection, UIDriver uiDriver) {
        super(nameOnScreen, collection, uiDriver);
    }

    CheckoutOption(String nameOnScreen, BookCollection collection) {
        super(nameOnScreen, collection);
    }

    CheckoutOption(String nameOnScreen) {
        super(nameOnScreen);
    }


    @Override
    public void select() {
        uiDriver.show(collection);
        String bookNameChoice =  uiDriver.getInput();

        try {
            collection.removeBook(bookNameChoice);
            uiDriver.show(SUCCESSFUL_CHECKOUT_MESSAGE);
        } catch (BookNotAvailableException exception) {
            uiDriver.show(UNSUCCESSFUL_CHECKOUT_MESSAGE);
        }
    }
}
