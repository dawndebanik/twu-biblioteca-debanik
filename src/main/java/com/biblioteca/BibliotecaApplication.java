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

        String userChoice;
        while(!(userChoice = userInterface.getInput())
                .equalsIgnoreCase("quit")){

            if (userChoice.equals(UserInterface.MENU_CHOICE_1)) {
                userInterface.showBooks(bookCollection);
            }
            else if (userChoice.equals(UserInterface.MENU_CHOICE_2)){
                userInterface.showBooks(bookCollection);
                String bookNameChoice = userInterface.getInput();
                bookCollection.checkOutBook(bookCollection.getBookWithName(bookNameChoice));
                userInterface.showMessage("Thank you! Enjoy the book.");
            }
            else {
                userInterface.showInvalidChoicePrompt();
            }
            userInterface.showMenu();
        }
    }
}
