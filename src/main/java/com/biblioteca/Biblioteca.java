package com.biblioteca;

import com.biblioteca.entities.BookCollection;
import com.biblioteca.menu.Menu;

// represents the library management system
class Biblioteca {
    private final UIDriver uiDriver;
    private final Menu menu;

    Biblioteca(BookCollection bookCollection, UIDriver uiDriver, Menu menu) {
        this.uiDriver = uiDriver;
        this.menu = menu;
    }

    void run() {
        uiDriver.show("Welcome to Biblioteca!");
        menu.interact();
        /*uiDriver.showGreeting();*/
        /*uiDriver.showMenu();*/
/*
*/

        /*String userChoice;*/
        /*while(!(userChoice = uiDriver.readInput())*/
        /*        .equalsIgnoreCase("quit")){*/
/*
*/

        /*    if (userChoice.equals("1")) {*/
        /*        uiDriver.showBooks(bookCollection);*/
        /*    }*/
        /*    else if (userChoice.equals("2")){*/
        /*        uiDriver.showBooks(bookCollection);*/
        /*        String bookNameChoice = uiDriver.readInput();*/
        /*        try {*/
        /*            bookCollection.removeBook(bookNameChoice);*/
        /*            uiDriver.showMessage("Thank you! Enjoy the book.");*/
        /*        } catch (BookNotAvailableException e) {*/
        /*            uiDriver.showMessage("That book is not available.");*/
        /*        }*/
        /*    }*/
        /*    else {*/
        /*        uiDriver.showInvalidChoicePrompt();*/
        /*    }*/
        /*    uiDriver.showMenu();*/
        /*}*/
    }
}