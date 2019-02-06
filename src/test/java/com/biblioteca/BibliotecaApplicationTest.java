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
                new BibliotecaApplication(consoleDriver, new StaticCollectionOfBooks());

        app.run();

        verify(consoleDriver).display("Welcome to Biblioteca Application!\n");
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
                new BibliotecaApplication(consoleDriver, collectionOfBooks);

        app.run();

        verify(consoleDriver).display("1                 War and Peace                   Leo Tolstoy                          1867");
    }



    @Test
    void expectsMenuToBeShownWhenUserEnters1() {
        IODriver userEnters1Driver = mock(IODriver.class);
        when(userEnters1Driver.readInput()).thenReturn("1");

        BookCollection collectionOfBooks = new StaticCollectionOfBooks();
        BibliotecaApplication app = new BibliotecaApplication(userEnters1Driver, collectionOfBooks);


        app.run();

        verify(userEnters1Driver).display("Welcome to Biblioteca Application!\n");
        verify(userEnters1Driver).display("1. List all books");
        verify(userEnters1Driver).display("Available books:");
        verify(userEnters1Driver).display("         1                 War and Peace                   Leo Tolstoy                          1867\n" +
                "         2         To Kill a Mockingbird                    Harper Lee                          1960\n");
    }
}
