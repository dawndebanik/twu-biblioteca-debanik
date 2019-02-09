package com.biblioteca.menu.option;

import ui.ConsoleUIDriver;
import ui.UIDriver;
import com.biblioteca.entities.BookCollection;
import com.biblioteca.entities.FixedBookCollection;

// represents a point of choice offered to the user
public abstract class MenuOption {
    final UIDriver uiDriver;
    final String nameOnScreen;
    final BookCollection collection;

    MenuOption(String nameOnScreen, BookCollection collection, UIDriver uiDriver) {
        this.nameOnScreen = nameOnScreen;
        this.collection = collection;
        this.uiDriver = uiDriver;
    }

    MenuOption(String nameOnScreen, BookCollection collection) {
        this(nameOnScreen, collection, new ConsoleUIDriver());
    }

    MenuOption(String nameOnScreen) {
        this(nameOnScreen, new FixedBookCollection(), new ConsoleUIDriver());
    }

    public String nameOnScreen(){
        return nameOnScreen;
    }

    public abstract void select();
}
