package com.biblioteca.menu.option;

import com.biblioteca.BookDoesNotBelongHereException;
import ui.UIDriver;
import com.biblioteca.entities.BookCollection;

// represents the choice of the user to return a book
public class ReturnOption extends MenuOption{
    private static final String ENTER_BOOK_NAME_PROMPT = "Enter the name of the book you want to return: ";
    private static final String SUCCESSFUL_RETURN_MESSAGE = "Thank you for returning the book.\n";
    private static final String UNSUCCESSFUL_RETURN_MESSAGE = "That is not a valid book to return.\n";

    public ReturnOption(String nameOnScreen, BookCollection collection, UIDriver uiDriver) {
        super(nameOnScreen, collection, uiDriver);
    }

    ReturnOption(String nameOnScreen, BookCollection collection) {
        super(nameOnScreen, collection);
    }

    ReturnOption(String nameOnScreen) {
        super(nameOnScreen);
    }

    @Override
    public void select() {
        uiDriver.show(ENTER_BOOK_NAME_PROMPT);
        String bookName = uiDriver.readInput();
        try {
            collection.addBook(bookName);
            uiDriver.show(SUCCESSFUL_RETURN_MESSAGE);
        } catch (BookDoesNotBelongHereException e) {
            uiDriver.show(UNSUCCESSFUL_RETURN_MESSAGE);
        }
    }
}
