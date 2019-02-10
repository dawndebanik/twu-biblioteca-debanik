package com.biblioteca.menu.option;

import com.biblioteca.entities.BookCollection;
import ui.UIDriver;

// represents the choice of the user to borrow a book
public class CheckoutBookOption extends CheckoutOption {
    public CheckoutBookOption(String nameOnScreen, BookCollection collection, UIDriver uiDriver) {
        super(nameOnScreen, collection, uiDriver);
        setPrompts();
    }

    private void setPrompts() {
        this.SUCCESSFUL_CHECKOUT_MESSAGE = "Thank you! Enjoy the book.\n";
        this.UNSUCCESSFUL_CHECKOUT_MESSAGE = "That book is not available. Maybe you spelt it wrong?\n";
        this.ENTER_BOOK_NAME_PROMPT = "Enter the name of the book you want to check out: ";
    }

    public CheckoutBookOption(String nameOnScreen) {
        super(nameOnScreen);
        setPrompts();
    }


    @Override
    public void select() {
        super.select();
    }
}
