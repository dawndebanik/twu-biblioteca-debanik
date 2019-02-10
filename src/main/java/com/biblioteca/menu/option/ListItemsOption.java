package com.biblioteca.menu.option;

import com.biblioteca.entities.ItemCollection;
import ui.UIDriver;

// represents the choice of the user to see all items
public class ListItemsOption extends MenuOption {
    public ListItemsOption(String nameOnScreen, ItemCollection collection, UIDriver uiDriver) {
        super(nameOnScreen, collection, uiDriver);
    }

    public ListItemsOption(String nameOnScreen, ItemCollection collection) {
        super(nameOnScreen, collection);
    }

    public ListItemsOption(String nameOnScreen) {
        super(nameOnScreen);
    }

    @Override
    public void select() {
        uiDriver.show(collection);
    }
}
