package com.biblioteca.menu.option;

import com.biblioteca.entities.BookCollection;
import com.biblioteca.entities.ItemCollection;
import com.biblioteca.entities.ItemNotAvailableException;
import ui.UIDriver;

// represents the choice of the user to borrow a book
public class CheckoutOption extends MenuOption {
    private String SUCCESSFUL_CHECKOUT_MESSAGE;
    private String UNSUCCESSFUL_CHECKOUT_MESSAGE;
    private String ENTER_ITEM_NAME_PROMPT;

    public CheckoutOption(String nameOnScreen, ItemCollection collection, UIDriver uiDriver) {
        super(nameOnScreen, collection, uiDriver);
        setPrompts();
    }

    public CheckoutOption(String nameOnScreen) {
        super(nameOnScreen);
        setPrompts();
    }

    @Override
    public void select() {
        uiDriver.show(collection);
        if (collection.isEmpty()) {
            return;
        }
        uiDriver.show(ENTER_ITEM_NAME_PROMPT);
        String itemNameChoice = uiDriver.readInput();
        try {
            collection.remove(itemNameChoice);
            uiDriver.show(SUCCESSFUL_CHECKOUT_MESSAGE);
        } catch (ItemNotAvailableException exception) {
            uiDriver.show(UNSUCCESSFUL_CHECKOUT_MESSAGE);
        }
    }

    private void setPrompts() {
        if (collection instanceof BookCollection){
            SUCCESSFUL_CHECKOUT_MESSAGE = "Thank you! Enjoy the book.";
            UNSUCCESSFUL_CHECKOUT_MESSAGE = "That book is not available.";
            ENTER_ITEM_NAME_PROMPT = "Enter the name of the book";
            return;
        }
        SUCCESSFUL_CHECKOUT_MESSAGE = "Thank you! Enjoy the movie.";
        UNSUCCESSFUL_CHECKOUT_MESSAGE = "That movie is not available.";
        ENTER_ITEM_NAME_PROMPT = "Enter the movie of the book";
    }
}
