package com.biblioteca.menu.option;

import ui.UIDriver;
import com.biblioteca.entities.BookCollection;

public class InvalidOption extends MenuOption {

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
        uiDriver.show(nameOnScreen);
    }
}
