package com.biblioteca;

import com.biblioteca.entities.BookCollection;
import com.biblioteca.menu.Menu;
import ui.UIDriver;

// represents the library management system
class Bibliotheca {
    private final UIDriver uiDriver;
    private final Menu menu;

    Bibliotheca(BookCollection bookCollection, UIDriver uiDriver, Menu menu) {
        this.uiDriver = uiDriver;
        this.menu = menu;
    }

    void run() {
        uiDriver.show("Welcome to Bibliotheca!");
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