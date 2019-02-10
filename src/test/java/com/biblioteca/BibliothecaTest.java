package com.biblioteca;

import com.biblioteca.entities.FixedBookCollection;
import com.biblioteca.menu.*;
import com.biblioteca.menu.option.CheckoutOption;
import com.biblioteca.menu.option.InvalidOption;
import com.biblioteca.menu.option.ListBooksOption;
import com.biblioteca.menu.option.MenuOption;
import org.junit.jupiter.api.Test;
import ui.ConsoleUIDriver;
import ui.UIDriver;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

class BibliothecaTest {
    @Test
    void expectsWelcomeMessageToBePrintedWhenApplicationStarts() {
        UIDriver consoleDriver = mock(ConsoleUIDriver.class);
        when(consoleDriver.readInput()).thenReturn("1").thenReturn("quit");
        Bibliotheca app =
                new Bibliotheca(
                        consoleDriver,
                        defaultMenuWith(consoleDriver));

        app.run();

        verify(consoleDriver).show(contains("Welcome to Bibliotheca!"));
    }

    private static Menu defaultMenuWith(UIDriver uiDriver) {
        MenuOption listBooks = new ListBooksOption("List Books");
        MenuOption checkout = new CheckoutOption("Checkout a book");
        MenuOption invalid = new InvalidOption("Select a valid Option!");
        List<MenuOption> options = new ArrayList<>();
        options.add(listBooks);
        options.add(checkout);

        return new Menu(options, invalid, uiDriver);
    }
}