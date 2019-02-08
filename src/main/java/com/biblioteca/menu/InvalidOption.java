package com.biblioteca.menu;

import com.biblioteca.entities.BookCollection;
import com.biblioteca.format.Formatter;
import com.biblioteca.io.IODriver;

public class InvalidOption extends MenuOption {
    private static final String PROMPT_INVALID_CHOICE = "Select a valid option!";

    public InvalidOption(BookCollection collection, IODriver ioDriver, Formatter formatter) {
        super(collection, ioDriver, formatter);
    }

    @Override
    public void select() {
        ioDriver.display(PROMPT_INVALID_CHOICE);
    }
}
