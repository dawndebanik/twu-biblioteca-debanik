package com.biblioteca;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class BibliotecaApplicationTest {
    @Test
    void expectsWelcomeMessageToBePrintedWhenApplicationStarts() {
        IODriver consoleDriver = mock(ConsoleIODriver.class);
        BibliotecaApplication app =
                new BibliotecaApplication(consoleDriver,
                        new BookCollection() {
                            @Override
                            public List<Book> getAllBooks() {
                                return Collections.EMPTY_LIST;
                            }

                            @Override
                            public String representation() {
                                return "";
                            }
                        });

        app.run();

        verify(consoleDriver).display("Welcome to Biblioteca Application!");
    }

    @Test
    void expectsListOfBooksToBeShownAfterTheWelcomeMessage() {
        IODriver consoleDriver = mock(ConsoleIODriver.class);
        BookCollection collectionOfBooks =
                new BookCollection() {
                    @Override
                    public List getAllBooks() {
                        return Collections.singletonList(new Book("Clean Code"));
                    }

                    @Override
                    public String representation() {
                        return new Book("Clean Code").toString();
                    }
                };
        BibliotecaApplication app =
                new BibliotecaApplication(consoleDriver, collectionOfBooks);

        app.run();

        verify(consoleDriver).display("Name : Clean Code");
    }
}
