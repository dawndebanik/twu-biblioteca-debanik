package com.biblioteca.menu.option;

import com.biblioteca.BookNotAvailableException;
import ui.UIDriver;
import com.biblioteca.entities.BookCollection;

// represents the choice of the user to borrow a book
public class CheckoutOption extends MenuOption {
    private static final String SUCCESSFUL_CHECKOUT_MESSAGE = "Thank you! Enjoy the book.\n";
    private static final String UNSUCCESSFUL_CHECKOUT_MESSAGE = "That book is not available. Maybe you spelt it wrong?\n";
    private static final String ENTER_BOOK_NAME_PROMPT = "Enter the name of the book you want to check out: ";

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
        if (collection.isEmpty()) {
            return;
        }
        uiDriver.show(ENTER_BOOK_NAME_PROMPT);
        String bookNameChoice = uiDriver.readInput();
        try {
            collection.removeBook(bookNameChoice);
            uiDriver.show(SUCCESSFUL_CHECKOUT_MESSAGE);
        } catch (BookNotAvailableException exception) {
            uiDriver.show(UNSUCCESSFUL_CHECKOUT_MESSAGE);
        }
    }
}
