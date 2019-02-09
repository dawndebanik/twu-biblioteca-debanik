package com.biblioteca;

import com.biblioteca.entities.BookCollection;
import com.biblioteca.entities.FixedBookCollection;
import com.biblioteca.menu.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UIDriver consoleDriver = new ConsoleUIDriver();
        Biblioteca application =
                new Biblioteca(new FixedBookCollection(),
                        consoleDriver,
                        defaultMenuWith(consoleDriver));

        application.run();
    }

    private static Menu defaultMenuWith(UIDriver uiDriver) {
        BookCollection collection = new FixedBookCollection();
        MenuOption listBooks = new ListBooksOption("List Books", collection, uiDriver);
        MenuOption checkout = new CheckoutOption("Checkout a book", collection, uiDriver);
        MenuOption invalid = new InvalidOption("Select a valid Option!", collection, uiDriver);
        List<MenuOption> options = new ArrayList<>();
        options.add(listBooks);
        options.add(checkout);

        return new Menu(options, invalid, uiDriver);
    }
}
