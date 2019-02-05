package com.biblioteca;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class BibliotecaApplicationTest {
    @Test
    void expectsWelcomeMessageToBePrintedWhenApplicationStarts() {
        IODriver consoleDriver = mock(ConsoleIODriver.class);
        BibliotecaApplication app = new BibliotecaApplication(consoleDriver);

        app.run();

        verify(consoleDriver).display("Welcome to Biblioteca Application!");
    }
}
