package com.biblioteca;

import com.biblioteca.entities.BookCollection;

// represents the library management system
class BibliotecaApplication {
    private final BookCollection bookCollection;
    private final UIDriver UIDriver;

    BibliotecaApplication(BookCollection bookCollection, UIDriver UIDriver) {
        this.bookCollection = bookCollection;
        this.UIDriver = UIDriver;

    }

    void run() {
        /*UIDriver.showGreeting();*/
        /*UIDriver.showMenu();*/
/*
*/

        /*String userChoice;*/
        /*while(!(userChoice = UIDriver.getInput())*/
        /*        .equalsIgnoreCase("quit")){*/
/*
*/

        /*    if (userChoice.equals("1")) {*/
        /*        UIDriver.showBooks(bookCollection);*/
        /*    }*/
        /*    else if (userChoice.equals("2")){*/
        /*        UIDriver.showBooks(bookCollection);*/
        /*        String bookNameChoice = UIDriver.getInput();*/
        /*        try {*/
        /*            bookCollection.removeBook(bookNameChoice);*/
        /*            UIDriver.showMessage("Thank you! Enjoy the book.");*/
        /*        } catch (BookNotAvailableException e) {*/
        /*            UIDriver.showMessage("That book is not available.");*/
        /*        }*/
        /*    }*/
        /*    else {*/
        /*        UIDriver.showInvalidChoicePrompt();*/
        /*    }*/
        /*    UIDriver.showMenu();*/
        /*}*/
    }
}