package com.biblioteca.menu;

import com.biblioteca.UIDriver;
import com.biblioteca.entities.BookCollection;

public class InvalidOption extends MenuOption {
    private static final String PROMPT_INVALID_CHOICE = "Select a valid option!";

    public InvalidOption(String nameOnScreen, BookCollection collection, UIDriver uiDriver) {
        super(nameOnScreen, collection, uiDriver);
    }

    InvalidOption(String nameOnScreen, BookCollection collection) {
        super(nameOnScreen, collection);
    }

    public InvalidOption(String nameOnScreen) {
        super(nameOnScreen);
    }

    @Override
    public void select() {
        uiDriver.show(PROMPT_INVALID_CHOICE);
    }
}
