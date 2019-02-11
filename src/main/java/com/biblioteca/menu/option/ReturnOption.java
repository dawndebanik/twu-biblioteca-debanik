package com.biblioteca.menu.option;

import com.biblioteca.entities.BookCollection;
import com.biblioteca.entities.ItemCollection;
import com.biblioteca.exceptions.ItemDoesNotBelongHereException;
import com.biblioteca.ui.UIDriver;

// represents the choice of the user to return an item
public class ReturnOption extends MenuOption {
    private static String ENTER_ITEM_NAME_PROMPT;
    private static String SUCCESSFUL_RETURN_MESSAGE;
    private static String UNSUCCESSFUL_RETURN_MESSAGE;

    public ReturnOption(String nameOnScreen, ItemCollection collection, UIDriver uiDriver) {
        super(nameOnScreen, collection, uiDriver);
        setPrompts();
    }

    ReturnOption(String nameOnScreen, ItemCollection collection) {
        super(nameOnScreen, collection);
        setPrompts();
    }

    ReturnOption(String nameOnScreen) {
        super(nameOnScreen);
        setPrompts();
    }

    @Override
    public void select() {
        uiDriver.show(ENTER_ITEM_NAME_PROMPT);
        String itemName = uiDriver.readInput();
        try {
            collection.add(itemName);
            uiDriver.show(SUCCESSFUL_RETURN_MESSAGE);
        } catch (ItemDoesNotBelongHereException e) {
            uiDriver.show(UNSUCCESSFUL_RETURN_MESSAGE);
        }
    }

    private void setPrompts() {
        if (collection instanceof BookCollection) {
            SUCCESSFUL_RETURN_MESSAGE = "Thank you for returning the book.\n";
            UNSUCCESSFUL_RETURN_MESSAGE = "That is not a valid book to return.\n";
            ENTER_ITEM_NAME_PROMPT = "Enter the name of the book you want to return: ";
            return;
        }
        SUCCESSFUL_RETURN_MESSAGE = "Thank you for returning the movie.\n";
        UNSUCCESSFUL_RETURN_MESSAGE = "That is not a valid movie to return.\n";
        ENTER_ITEM_NAME_PROMPT = "Enter the name of the movie you want to return: ";
    }
}
