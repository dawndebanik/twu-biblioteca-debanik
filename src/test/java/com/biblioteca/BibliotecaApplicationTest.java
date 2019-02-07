package com.biblioteca;

import org.junit.jupiter.api.Test;
import org.mockito.Matchers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

class BibliotecaApplicationTest {
    @Test
    void expectsWelcomeMessageToBePrintedWhenApplicationStarts() {
        IODriver consoleDriver = mock(ConsoleIODriver.class);
        when(consoleDriver.readInput()).thenReturn("1");
        BibliotecaApplication app =
                new BibliotecaApplication(
                        new FixedBookCollection(),
                        new ConsoleUI(consoleDriver));

        app.run();

        verify(consoleDriver).display("Welcome to Biblioteca!\n");
    }

    @Test
    void expectsBookListToBeShownWhenUserEnters1() {
        IODriver userEnters1 = mock(IODriver.class);
        when(userEnters1.readInput()).thenReturn("1");
        BibliotecaApplication app =
                new BibliotecaApplication
                        (new FixedBookCollection(), new ConsoleUI(userEnters1));


        app.run();

        verify(userEnters1).display("Available books:");
        verify(userEnters1).display("         1                 War and Peace                   Leo Tolstoy                          1867\n" +
                "         2         To Kill a Mockingbird                    Harper Lee                          1960\n");
    }

    @Test
    void expectsInvalidOptionPromptWhenUserEntersInvalidInput() {
        IODriver userEntersInvalid = mock(ConsoleIODriver.class);
        when(userEntersInvalid.readInput()).thenReturn("5");
        BibliotecaApplication app =
                new BibliotecaApplication
                        (new FixedBookCollection(), new ConsoleUI(userEntersInvalid));

        app.run();

        verify(userEntersInvalid, atLeastOnce()).display("Select a valid option!");
    }

    @Test
    void expectsQuitOptionToBeGivenToUser() {
        IODriver consoleIODriver = mock(ConsoleIODriver.class);
        when(consoleIODriver.readInput()).thenReturn("");
        BibliotecaApplication app =
                new BibliotecaApplication
                        (new FixedBookCollection(), new ConsoleUI(consoleIODriver));

        app.run();

        verify(consoleIODriver, atLeastOnce()).display("Type 'quit' to exit.");
    }

    @Test
    void expectsOptionForCheckoutToBeGivenToUser() {
        IODriver consoleIODriver = mock(ConsoleIODriver.class);
        when(consoleIODriver.readInput()).thenReturn("");
        BibliotecaApplication app =
                new BibliotecaApplication
                        (new FixedBookCollection(), new ConsoleUI(consoleIODriver));

        app.run();

        verify(consoleIODriver).display("2. Checkout a book");
    }

    @Test
    void expectsCheckedOutBookToBeUnavailable() {
        IODriver consoleIODriver = mock(ConsoleIODriver.class);
        when(consoleIODriver.readInput())
                .thenReturn("2").thenReturn("1");
        BibliotecaApplication app =
                new BibliotecaApplication
                        (new FixedBookCollection(), new ConsoleUI(consoleIODriver));

        app.run();

        verify(consoleIODriver, atMost(1))
                .display(contains("War and Peace"));
        verify(consoleIODriver, never())
                .display(contains("Select a valid option!\n"));
    }


}
