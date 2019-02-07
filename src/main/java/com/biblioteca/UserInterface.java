package com.biblioteca;

import com.biblioteca.io.IODriver;

// represents a contract how the interaction
// with the user is defined
abstract class UserInterface {
    static final String MENU_CHOICE_1 = "1";
    static final String MENU_CHOICE_2 = "2";
    static final String MENU_CHOICE_QUIT = "quit";

    final IODriver ioDriver;

    UserInterface(IODriver ioDriver){
        this.ioDriver = ioDriver;
    }

    abstract String getInput();
    abstract void showGreeting();
    abstract void showMenu();
    abstract void showBooks(BookCollection collection);
    abstract void showInvalidChoicePrompt();
}
