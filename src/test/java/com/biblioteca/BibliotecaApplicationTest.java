package com.biblioteca;

import com.biblioteca.io.ConsoleIODriver;
import com.biblioteca.io.IODriver;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class BibliotecaApplicationTest {
    @Test
    void expectsWelcomeMessageToBePrintedWhenApplicationStarts() {
        IODriver consoleDriver = mock(ConsoleIODriver.class);
        when(consoleDriver.readInput()).thenReturn("1").thenReturn("quit");
        BibliotecaApplication app =
                new BibliotecaApplication(
                        new FixedBookCollection(),
                        new ConsoleUI(consoleDriver));

        app.run();

        verify(consoleDriver).display(contains("Welcome to Biblioteca!"));
    }

    @Test
    void expectsBookListToBeShownWhenUserEnters1() {
        IODriver userEnters1 = mock(IODriver.class);
        when(userEnters1.readInput()).thenReturn("1").thenReturn("quit");
        BibliotecaApplication app =
                new BibliotecaApplication
                        (new FixedBookCollection(), new ConsoleUI(userEnters1));


        app.run();

        verify(userEnters1).display("Available books:");
        verify(userEnters1).display(contains("War and Peace"));
        verify(userEnters1).display(contains("To Kill a Mockingbird"));
    }

    @Test
    void expectsInvalidOptionPromptWhenUserEntersInvalidInput() {
        IODriver userEntersInvalid = mock(ConsoleIODriver.class);
        when(userEntersInvalid.readInput()).thenReturn("5").thenReturn("quit");
        BibliotecaApplication app =
                new BibliotecaApplication
                        (new FixedBookCollection(), new ConsoleUI(userEntersInvalid));

        app.run();

        verify(userEntersInvalid, atLeastOnce())
                .display(contains("Select a valid option"));
    }

    @Test
    void expectsQuitOptionToBeGivenToUser() {
        IODriver consoleIODriver = mock(ConsoleIODriver.class);
        when(consoleIODriver.readInput()).thenReturn("quit");
        BibliotecaApplication app =
                new BibliotecaApplication
                        (new FixedBookCollection(), new ConsoleUI(consoleIODriver));

        app.run();

        verify(consoleIODriver, atLeastOnce())
                .display(contains("Type 'quit' to exit."));
    }

    @Test
    void expectsOptionForCheckoutToBeGivenToUser() {
        IODriver consoleIODriver = mock(ConsoleIODriver.class);
        when(consoleIODriver.readInput()).thenReturn("quit");
        BibliotecaApplication app =
                new BibliotecaApplication
                        (new FixedBookCollection(), new ConsoleUI(consoleIODriver));

        app.run();

        verify(consoleIODriver, atLeastOnce())
                .display(contains("2. Checkout a book"));
    }

    @Test
    void expectsCheckedOutBookToBeUnavailable() {
        IODriver consoleIODriver = mock(ConsoleIODriver.class);
        when(consoleIODriver.readInput())
                .thenReturn("2").thenReturn("War and Peace").thenReturn("1").thenReturn("quit");
        BibliotecaApplication app =
                new BibliotecaApplication
                        (new FixedBookCollection(), new ConsoleUI(consoleIODriver));

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
        BibliotecaApplication app =
                new BibliotecaApplication
                        (new FixedBookCollection(), new ConsoleUI(consoleIODriver));

        app.run();

        verify(consoleIODriver, times(1))
                .display(contains("Thank you! Enjoy the book."));
    }
}
