package com.biblioteca;

import com.biblioteca.io.IODriver;

import java.util.Arrays;
import java.util.List;

// represents the library management system
class BibliotecaApplication {
    private final BookCollection bookCollection;
    private final UserInterface userInterface;

    BibliotecaApplication(BookCollection bookCollection, UserInterface userInterface) {
        this.bookCollection = bookCollection;
        this.userInterface = userInterface;

    }

    void run() {
        userInterface.showGreeting();
        userInterface.showMenu();

        String userChoice;
        while(!(userChoice = userInterface.getInput())
                .equalsIgnoreCase("quit")){

            if (userChoice.equals(UserInterface.MENU_CHOICE_1)) {
                userInterface.showBooks(bookCollection);
            }
            else if (userChoice.equals(UserInterface.MENU_CHOICE_2)){
                userInterface.showBooks(bookCollection);
                String bookNameChoice = userInterface.getInput();
                try {
                    bookCollection.removeBook(bookNameChoice);
                    userInterface.showMessage("Thank you! Enjoy the book.");
                } catch (BookNotAvailableException e) {
                    userInterface.showMessage("That book is not available.");
                }
            }
            else {
                userInterface.showInvalidChoicePrompt();
            }
            userInterface.showMenu();
        }
    }
}