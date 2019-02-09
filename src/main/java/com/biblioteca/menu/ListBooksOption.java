package com.biblioteca.menu;

import com.biblioteca.UIDriver;
import com.biblioteca.entities.BookCollection;

public class ListBooksOption extends MenuOption {

    public ListBooksOption(String nameOnScreen, BookCollection collection, UIDriver uiDriver) {
        super(nameOnScreen, collection, uiDriver);
    }

    ListBooksOption(String nameOnScreen, BookCollection collection) {
        super(nameOnScreen, collection);
    }

    public ListBooksOption(String nameOnScreen) {
        super(nameOnScreen);
    }

    @Override
    public void select() {
        uiDriver.show(collection);
    }
}
