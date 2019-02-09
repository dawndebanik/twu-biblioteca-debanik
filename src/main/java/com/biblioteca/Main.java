package com.biblioteca;

import com.biblioteca.entities.BookCollection;
import com.biblioteca.entities.FixedBookCollection;
import com.biblioteca.menu.*;
import com.biblioteca.menu.option.*;
import ui.ConsoleUIDriver;
import ui.UIDriver;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UIDriver consoleDriver = new ConsoleUIDriver();
        Bibliotheca application =
                new Bibliotheca(new FixedBookCollection(),
                        consoleDriver,
                        defaultMenuWith(consoleDriver));

        application.run();
    }

    private static Menu defaultMenuWith(UIDriver uiDriver) {
        BookCollection collection = new FixedBookCollection();
        MenuOption listBooks = new ListBooksOption("List books", collection, uiDriver);
        MenuOption checkout = new CheckoutOption("Checkout a book", collection, uiDriver);
        MenuOption invalid = new InvalidOption("elect a valid option!", collection, uiDriver);
        MenuOption returnBook = new ReturnOption("Return a book", collection, uiDriver);

        List<MenuOption> options = new ArrayList<>();
        options.add(listBooks);
        options.add(checkout);
        options.add(returnBook);

        return new Menu(options, invalid, uiDriver);
    }
}
