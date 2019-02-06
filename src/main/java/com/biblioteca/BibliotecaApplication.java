package com.biblioteca;

// represents the library management system
class BibliotecaApplication {
    private static final String WELCOME_MESSAGE = "Welcome to Biblioteca Application!\n";
    private static final String AVAILABLE_BOOKS_HEADER = "Available books:";
    private static final String MENU_OPTION_LIST_ALL_BOOKS = "1. List all books";
    private static final String MENU_OPTION_QUIT = "Type 'quit' to exit.";
    private static final String PROMPT_INVALID_CHOICE = "Select a valid option!";
    private static final String MENU_CHOICE_1 = "1";
    private static final String MENU_CHOICE_QUIT = "quit";

    private final IODriver ioDriver;
    private final BookCollection bookCollection;

    BibliotecaApplication(IODriver ioDriver, BookCollection bookCollection) {
        this.ioDriver = ioDriver;
        this.bookCollection = bookCollection;
    }

    void run() {
        ioDriver.display(WELCOME_MESSAGE);

        showMenu();

        String userChoice = ioDriver.readInput().trim();
        if (userChoice.equals(MENU_CHOICE_1)) {
            showBooks();
            return;
        }
        if (userChoice.equalsIgnoreCase(MENU_CHOICE_QUIT)) {
            return;
        }
        ioDriver.display(PROMPT_INVALID_CHOICE);
    }

    private void showMenu() {
        ioDriver.display(MENU_OPTION_LIST_ALL_BOOKS);
        ioDriver.display(MENU_OPTION_QUIT);
    }

    private void showBooks() {
        ioDriver.display(AVAILABLE_BOOKS_HEADER);
        ioDriver.display(bookCollection.representation());
    }
}
