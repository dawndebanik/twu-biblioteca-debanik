package com.biblioteca;

import com.biblioteca.entities.FixedBookCollection;
import com.biblioteca.menu.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

class BibliotecaTest {
    @Test
    void expectsWelcomeMessageToBePrintedWhenApplicationStarts() {
        UIDriver consoleDriver = mock(ConsoleUIDriver.class);
        when(consoleDriver.readInput()).thenReturn("1").thenReturn("quit");
        Biblioteca app =
                new Biblioteca(
                        new FixedBookCollection(),
                        consoleDriver,
                        defaultMenuWith(consoleDriver));

        app.run();

        verify(consoleDriver).show(contains("Welcome to Biblioteca!"));
    }

    /*
    @Test
    void expectsInvalidOptionPromptWhenUserEntersInvalidInput() {
        IODriver userEntersInvalid = mock(ConsoleIODriver.class);
        when(userEntersInvalid.readInput()).thenReturn("5").thenReturn("quit");
        Biblioteca app =
                new Biblioteca
                        (new FixedBookCollection(), );

        app.run();

        verify(userEntersInvalid, atLeastOnce())
                .display(contains("Select a valid option"));
    }

    @Test
    void expectsQuitOptionToBeGivenToUser() {
        IODriver consoleIODriver = mock(ConsoleIODriver.class);
        when(consoleIODriver.readInput()).thenReturn("quit");
        Biblioteca app =
                new Biblioteca
                        (new FixedBookCollection(), );

        app.run();

        verify(consoleIODriver, atLeastOnce())
                .display(contains("Type 'quit' to exit."));
    }

    @Test
    void expectsOptionForCheckoutToBeGivenToUser() {
        IODriver consoleIODriver = mock(ConsoleIODriver.class);
        when(consoleIODriver.readInput()).thenReturn("quit");
        Biblioteca app =
                new Biblioteca
                        (new FixedBookCollection(), );

        app.run();

        verify(consoleIODriver, atLeastOnce())
                .display(contains("2. Checkout a book"));
    }

    @Test
    void expectsCheckedOutBookToBeUnavailable() {
        IODriver consoleIODriver = mock(ConsoleIODriver.class);
        when(consoleIODriver.readInput())
                .thenReturn("2").thenReturn("War and Peace").thenReturn("1").thenReturn("quit");
        Biblioteca app =
                new Biblioteca
                        (new FixedBookCollection(), );

        app.run();

        verify(consoleIODriver, atMost(1))
                .display(contains("War and Peace"));
        verify(consoleIODriver, never())
                .display(contains("Select a valid option!\n"));
    }

    @Test
    void expectsSuccessfulCheckoutMessageOnSuccessfulCheckout() {
        IODriver consoleIODriver = mock(ConsoleIODriver.class);
        when(consoleIODriver.readInput())
                .thenReturn("2").thenReturn("War and Peace").thenReturn("1").thenReturn("quit");
        Biblioteca app =
                new Biblioteca
                        (new FixedBookCollection(), );

        app.run();

        verify(consoleIODriver, times(1))
                .display(contains("Thank you! Enjoy the book."));
    }

    @Test
    void expectsBookNotAvailableMessageWhenRequestedBookIsUnavailable() {
        IODriver consoleIODriver = mock(ConsoleIODriver.class);
        when(consoleIODriver.readInput())
                .thenReturn("2").thenReturn("Random book").thenReturn("1").thenReturn("quit");
        Biblioteca app =
                new Biblioteca
                        (new FixedBookCollection(), );

        app.run();

        verify(consoleIODriver, times(1))
                .display(contains("That book is not available."));
        verify(consoleIODriver, never())
                .display(contains("Thank you! Enjoy the book."));
    }*/

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