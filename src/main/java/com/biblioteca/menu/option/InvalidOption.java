package com.biblioteca.menu.option;

import ui.UIDriver;
import com.biblioteca.entities.BookCollection;

// represents a case where the choice of the user is not within defined choices
public class InvalidOption extends MenuOption {

    private static final String NEWLINE = "\n";

    public InvalidOption(String nameOnScreen, BookCollection collection, UIDriver uiDriver) {
        super(nameOnScreen, collection, uiDriver);
    }

    public InvalidOption(String nameOnScreen) {
        super(nameOnScreen);
    }

    @Override
    public void select() {
        uiDriver.show(nameOnScreen + NEWLINE);
    }
}
