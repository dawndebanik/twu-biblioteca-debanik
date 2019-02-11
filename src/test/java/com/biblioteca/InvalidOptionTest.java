package com.biblioteca;

import com.biblioteca.entities.FixedBookCollection;
import com.biblioteca.menu.option.InvalidOption;
import com.biblioteca.menu.option.MenuOption;
import org.junit.jupiter.api.Test;
import com.biblioteca.ui.ConsoleUIDriver;
import com.biblioteca.ui.UIDriver;

import static org.mockito.Mockito.*;

class InvalidOptionTest {
    @Test
    void expectsInvalidOptionPromptWhenChoiceIsInvalid() {
        UIDriver consoleDriver = mock(ConsoleUIDriver.class);
        MenuOption invalid =
                new InvalidOption("Select a valid option!", new FixedBookCollection(), consoleDriver);
        when(consoleDriver.readInput()).thenReturn("9");

        invalid.select();

        verify(consoleDriver).show(contains("Select a valid option!"));
    }
}
