package com.biblioteca;

import com.biblioteca.entities.BookCollection;
import com.biblioteca.io.IODriver;

// represents how the user sees
// the output on the console
class ConsoleUI extends UserInterface {
    private static final String WELCOME_MESSAGE = "Welcome to Biblioteca!\n";
    private static final String AVAILABLE_BOOKS_HEADER = "Available books:";
    private static final String MENU_OPTION_LIST_ALL_BOOKS = "1. List all books";
    private static final String MENU_OPTION_QUIT = "Type 'quit' to exit.";
    private static final String PROMPT_INVALID_CHOICE = "Select a valid option!";
    private static final String MENU_OPTION_CHECKOUT = "2. Checkout a book";

    ConsoleUI(IODriver driver) {
        super(driver);
    }

    @Override
    String getInput() {
        return ioDriver.readInput().trim();
    }

    @Override
    void showGreeting() {
        ioDriver.display(WELCOME_MESSAGE);
    }

    @Override
    void showMenu() {
        ioDriver.display(MENU_OPTION_LIST_ALL_BOOKS);
        ioDriver.display(MENU_OPTION_CHECKOUT);
        ioDriver.display(MENU_OPTION_QUIT);
    }

    @Override
    void showBooks(BookCollection collection) {
        ioDriver.display(AVAILABLE_BOOKS_HEADER);
        // ioDriver.display(collection.representation());
    }

    @Override
    void showInvalidChoicePrompt() {
        ioDriver.display(PROMPT_INVALID_CHOICE);
    }

    @Override
    void showMessage(String message) {
        ioDriver.display(message);
    }
}
