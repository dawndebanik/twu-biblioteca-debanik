package com.biblioteca;

import com.biblioteca.io.IODriver;

public class InvalidOption extends MenuOption {
    private static final String PROMPT_INVALID_CHOICE = "Select a valid option!";

    public InvalidOption(BookCollection collection, IODriver ioDriver, Formatter formatter) {
        super(collection, ioDriver, formatter);
    }

    @Override
    void onSelect() {
        ioDriver.display(PROMPT_INVALID_CHOICE);
    }
}
