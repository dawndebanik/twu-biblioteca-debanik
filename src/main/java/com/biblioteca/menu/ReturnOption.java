package com.biblioteca.menu;

import com.biblioteca.UIDriver;
import com.biblioteca.entities.BookCollection;

public class ReturnOption extends MenuOption{

    ReturnOption(String nameOnScreen, BookCollection collection, UIDriver uiDriver) {
        super(nameOnScreen, collection, uiDriver);
    }

    ReturnOption(String nameOnScreen, BookCollection collection) {
        super(nameOnScreen, collection);
    }

    ReturnOption(String nameOnScreen) {
        super(nameOnScreen);
    }

    @Override
    public void select() {

    }
}
