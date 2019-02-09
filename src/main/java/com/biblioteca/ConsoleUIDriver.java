package com.biblioteca;

import com.biblioteca.entities.BookCollection;
import com.biblioteca.format.ConsoleFormatter;
import com.biblioteca.format.Formatter;
import com.biblioteca.io.ConsoleIODriver;
import com.biblioteca.io.IODriver;
import com.biblioteca.menu.Menu;
import com.biblioteca.menu.MenuOption;

// represents how the user sees
// the output on the console
public class ConsoleUIDriver extends UIDriver {
    private static final String WELCOME_MESSAGE = "Welcome to Biblioteca!\n";
    private static final String AVAILABLE_BOOKS_HEADER = "Available books:";
    private static final String MENU_OPTION_LIST_ALL_BOOKS = "1. List all books";
    private static final String MENU_OPTION_QUIT = "Type 'quit' to exit.";
    private static final String PROMPT_INVALID_CHOICE = "Select a valid option!";
    private static final String MENU_OPTION_CHECKOUT = "2. Checkout a book";

    ConsoleUIDriver(IODriver ioDriver, Formatter formatter) {
        super(ioDriver, formatter);
    }

    public ConsoleUIDriver() {
        super();
    }

    @Override
    public String getInput() {
        return ioDriver.readInput().trim();
    }

    @Override
    public void show(BookCollection collection) {
        ioDriver.display(formatter.format(collection));
    }

    @Override
    public void show(String message) {
        ioDriver.display(formatter.format(message));
    }

    @Override
    public void show(Menu menu) {
        ioDriver.display(formatter.format(menu));
    }
}
