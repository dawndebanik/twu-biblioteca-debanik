package com.biblioteca;

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

        String userChoice = userInterface.getInput();

        if (userChoice.equals(UserInterface.MENU_CHOICE_1)) {
            userInterface.showBooks(bookCollection);
            return;
        }
        if (userChoice.equalsIgnoreCase(UserInterface.MENU_CHOICE_QUIT)) {
            return;
        }

        userInterface.showInvalidChoicePrompt();
    }
}
