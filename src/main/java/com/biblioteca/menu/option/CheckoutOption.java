package com.biblioteca.menu.option;

import com.biblioteca.entities.ItemCollection;
import com.biblioteca.entities.ItemNotAvailableException;
import ui.UIDriver;

public abstract class CheckoutOption extends MenuOption {
    String SUCCESSFUL_CHECKOUT_MESSAGE;
    String UNSUCCESSFUL_CHECKOUT_MESSAGE;
    String ENTER_BOOK_NAME_PROMPT;

    CheckoutOption(String nameOnScreen, ItemCollection collection, UIDriver uiDriver) {
        super(nameOnScreen, collection, uiDriver);
    }

    CheckoutOption(String nameOnScreen) {
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
