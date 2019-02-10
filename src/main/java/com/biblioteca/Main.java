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
    private static BookCollection collection = new FixedBookCollection();
    private static UIDriver consoleDriver = new ConsoleUIDriver();
    private static Menu defaultMenu = defaultMenu();

    public static void main(String[] args) {
        Bibliotheca application =
                new Bibliotheca(consoleDriver, defaultMenu);

        application.run();
    }

    private static Menu defaultMenu() {
        MenuOption listBooks = new ListItemsOption("List books", collection, consoleDriver);
        MenuOption checkout = new CheckoutOption("Checkout a book", collection, consoleDriver);
        MenuOption invalid = new InvalidOption("Select a valid option!", collection, consoleDriver);
        MenuOption returnBook = new ReturnBookOption("Return a book", collection, consoleDriver);

        List<MenuOption> options = new ArrayList<>();
        options.add(listBooks);
        options.add(checkout);
        options.add(returnBook);

        return new Menu(options, invalid, consoleDriver);
    }
}
