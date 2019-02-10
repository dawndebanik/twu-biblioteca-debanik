package com.biblioteca.menu.option;

import ui.UIDriver;
import com.biblioteca.entities.BookCollection;

// represents the choice of the user to see all books
public class ListBooksOption extends MenuOption {
    public ListBooksOption(String nameOnScreen, BookCollection collection, UIDriver uiDriver) {
        super(nameOnScreen, collection, uiDriver);
    }

    public ListBooksOption(String nameOnScreen, BookCollection collection) {
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
