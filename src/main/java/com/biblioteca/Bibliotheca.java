package com.biblioteca;

import com.biblioteca.entities.BookCollection;
import com.biblioteca.menu.Menu;
import ui.UIDriver;

// represents the library management system
class Bibliotheca {
    private final UIDriver uiDriver;
    private final Menu menu;

    Bibliotheca(UIDriver uiDriver, Menu menu) {
        this.uiDriver = uiDriver;
        this.menu = menu;
    }

    void run() {
        uiDriver.show("Welcome to Bibliotheca!");
        menu.interact();
    }
}