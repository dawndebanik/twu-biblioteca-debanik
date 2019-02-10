package com.biblioteca;

import com.biblioteca.menu.Menu;
import ui.UIDriver;

// represents the library management system
class Bibliotheca {
    private static final String WELCOME_MESSAGE = "Welcome to Bibliotheca!";
    private static final String GOODBYE_MESSAGE = "Goodbye! Thanks for using Bibliotheca!";
    private final UIDriver uiDriver;
    private final Menu menu;

    Bibliotheca(UIDriver uiDriver, Menu menu) {
        this.uiDriver = uiDriver;
        this.menu = menu;
    }

    void run() {
        uiDriver.show(WELCOME_MESSAGE);
        menu.interact();
        uiDriver.show(GOODBYE_MESSAGE);
    }
}