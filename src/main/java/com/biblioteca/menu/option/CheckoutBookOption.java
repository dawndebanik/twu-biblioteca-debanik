package com.biblioteca.menu.option;

import com.biblioteca.entities.BookCollection;
import com.biblioteca.entities.ItemNotAvailableException;
import ui.UIDriver;

// represents the choice of the user to borrow a book
public class CheckoutBookOption extends MenuOption {
    private static final String SUCCESSFUL_CHECKOUT_MESSAGE = "Thank you! Enjoy the book.\n";
    private static final String UNSUCCESSFUL_CHECKOUT_MESSAGE = "That book is not available. Maybe you spelt it wrong?\n";
    private static final String ENTER_BOOK_NAME_PROMPT = "Enter the name of the book you want to check out: ";

    public CheckoutBookOption(String nameOnScreen, BookCollection collection, UIDriver uiDriver) {
        super(nameOnScreen, collection, uiDriver);
    }

    CheckoutBookOption(String nameOnScreen, BookCollection collection) {
        super(nameOnScreen, collection);
    }

    public CheckoutBookOption(String nameOnScreen) {
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
            collection.remove(bookNameChoice);
            uiDriver.show(SUCCESSFUL_CHECKOUT_MESSAGE);
        } catch (ItemNotAvailableException exception) {
            uiDriver.show(UNSUCCESSFUL_CHECKOUT_MESSAGE);
        }
    }
}
