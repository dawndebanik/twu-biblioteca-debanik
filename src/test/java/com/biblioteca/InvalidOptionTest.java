package com.biblioteca;

import com.biblioteca.entities.FixedBookCollection;
import com.biblioteca.format.ConsoleFormatter;
import com.biblioteca.io.ConsoleIODriver;
import com.biblioteca.io.IODriver;
import com.biblioteca.menu.option.InvalidOption;
import com.biblioteca.menu.option.MenuOption;
import org.junit.jupiter.api.Test;
import ui.ConsoleUIDriver;

import static org.mockito.Mockito.*;

class InvalidOptionTest {
    @Test
    void expectsInvalidOptionPromptWhenChoiceIsInvalid() {
        IODriver ioDriver = mock(ConsoleIODriver.class);
        MenuOption invalid =
                new InvalidOption(null, new FixedBookCollection(), new ConsoleUIDriver(ioDriver, new ConsoleFormatter()));
        when(ioDriver.readInput()).thenReturn("9");

        invalid.select();

        verify(ioDriver).display(contains("Select a valid option!"));
    }
}
