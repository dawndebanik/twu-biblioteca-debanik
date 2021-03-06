package com.biblioteca.menu.option;

import com.biblioteca.entities.FixedBookCollection;
import com.biblioteca.entities.ItemCollection;
import com.biblioteca.ui.ConsoleUIDriver;
import com.biblioteca.ui.UIDriver;

// represents a point of choice offered to the user
public abstract class MenuOption {
    final UIDriver uiDriver;
    final String nameOnScreen;
    final ItemCollection collection;

    MenuOption(String nameOnScreen, ItemCollection collection, UIDriver uiDriver) {
        this.nameOnScreen = nameOnScreen;
        this.collection = collection;
        this.uiDriver = uiDriver;
    }

    MenuOption(String nameOnScreen, ItemCollection collection) {
        this(nameOnScreen, collection, new ConsoleUIDriver());
    }

    MenuOption(String nameOnScreen) {
        this(nameOnScreen, new FixedBookCollection(), new ConsoleUIDriver());
    }

    public String nameOnScreen() {
        return nameOnScreen;
    }

    public abstract void select();
}
