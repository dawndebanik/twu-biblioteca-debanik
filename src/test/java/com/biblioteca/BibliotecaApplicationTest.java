package com.biblioteca;

import org.junit.jupiter.api.Test;

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
                        new StaticCollectionOfBooks(),
                        new ConsoleUI(consoleDriver));

        app.run();

        verify(consoleDriver).display("Welcome to Biblioteca!\n");
    }

    @Test
    void expectsListOfBooksToBeShownAfterTheWelcomeMessage() {
        IODriver consoleDriver = mock(ConsoleIODriver.class);
        when(consoleDriver.readInput()).thenReturn("1");
        BookCollection collectionOfBooks =
                new BookCollection() {
                    @Override
                    public List getAllBooks() {
                        return Collections.singletonList(new Book("War and Peace", "Leo Tolstoy", "1867"));
                    }

                    @Override
                    public String representation() {
                        return String.format("1%1$10s", new Book("War and Peace", "Leo Tolstoy", "1867").representation());
                    }
                };
        BibliotecaApplication app =
                new BibliotecaApplication(collectionOfBooks, new ConsoleUI(consoleDriver));

        app.run();

        verify(consoleDriver).display("1                 War and Peace                   Leo Tolstoy                          1867");
    }


    @Test
    void expectsBookListToBeShownWhenUserEnters1() {
        IODriver userEnters1 = mock(IODriver.class);
        when(userEnters1.readInput()).thenReturn("1");

        BibliotecaApplication app =
                new BibliotecaApplication
                        (new StaticCollectionOfBooks(), new ConsoleUI(userEnters1));


        app.run();

        verify(userEnters1, times(1)).display("Welcome to Biblioteca!\n");
        verify(userEnters1, times(1)).display("1. List all books");
        verify(userEnters1, times(1)).display("Type 'quit' to exit.");
        verify(userEnters1, atLeastOnce()).display("Available books:");
        verify(userEnters1, atLeastOnce()).display("         1                 War and Peace                   Leo Tolstoy                          1867\n" +
                "         2         To Kill a Mockingbird                    Harper Lee                          1960\n");
    }

    @Test
    void expectsInvalidOptionPromptWhenUserEntersInvalidInput() {
        IODriver userEntersInvalid = mock(ConsoleIODriver.class);
        when(userEntersInvalid.readInput()).thenReturn("5");

        BibliotecaApplication app =
                new BibliotecaApplication
                        (new StaticCollectionOfBooks(), new ConsoleUI(userEntersInvalid));

        app.run();

        verify(userEntersInvalid, atLeastOnce()).display("Select a valid option!");
    }

    @Test
    void expectsQuitOptionToBeGivenToUser() {
        IODriver consoleIODriver = mock(ConsoleIODriver.class);
        when(consoleIODriver.readInput()).thenReturn("");

        BibliotecaApplication app =
                new BibliotecaApplication
                        (new StaticCollectionOfBooks(), new ConsoleUI(consoleIODriver));

        app.run();

        verify(consoleIODriver, atLeastOnce()).display("Type 'quit' to exit.");
    }
}
