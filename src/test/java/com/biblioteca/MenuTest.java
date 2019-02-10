package com.biblioteca;

import com.biblioteca.menu.*;
import com.biblioteca.menu.option.CheckoutBookOption;
import com.biblioteca.menu.option.InvalidOption;
import com.biblioteca.menu.option.ListBooksOption;
import com.biblioteca.menu.option.MenuOption;
import org.junit.jupiter.api.Test;
import ui.ConsoleUIDriver;
import ui.UIDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class MenuTest {
    @Test
    void expectsMenuToSelectProperOptionBasedOnInputString() {
        MenuOption checkout = mock(CheckoutBookOption.class);
        List<MenuOption> options = new ArrayList<>();
        options.add(checkout);
        MenuOption defaultOption = mock(InvalidOption.class);
        Menu menu = new Menu(options, defaultOption, new ConsoleUIDriver());

        menu.select("1");

        verify(checkout, atLeastOnce()).select();
    }

    @Test
    void expectsInvalidOptionToBeSelectedWhenInputIsInvalid() {
        MenuOption checkout = mock(CheckoutBookOption.class);
        List<MenuOption> options = new ArrayList<>();
        options.add(checkout);
        MenuOption defaultOption = mock(InvalidOption.class);
        Menu menu = new Menu(options, defaultOption, new ConsoleUIDriver());

        menu.select("random");

        verify(defaultOption, atLeastOnce()).select();
    }

    @Test
    void expectsProperDisplayOptionsFromMenu() {
        MenuOption checkout = new CheckoutBookOption("Checkout");
        MenuOption invalid = new InvalidOption("Invalid");
        Menu menu = new Menu(Collections.singletonList(checkout), invalid, new ConsoleUIDriver());

        assertEquals(Collections.singletonList("Checkout"), menu.getDisplayOptions());
    }

    @Test
    void expectsExitToBeShownWhenUserEntersQuit() {
        UIDriver userEnters1 = mock(ConsoleUIDriver.class);
        MenuOption listBooks = mock(ListBooksOption.class);
        MenuOption checkout = mock(CheckoutBookOption.class);
        when(userEnters1.readInput()).thenReturn("quit");
        Menu menu = new Menu(Arrays.asList(listBooks, checkout), mock(InvalidOption.class), userEnters1);

        menu.interact();

        verify(listBooks, never()).select();
        verify(checkout, never()).select();
    }
    @Test
    void expectsBookListToBeShownWhenUserEnters1() {
        UIDriver userEnters1 = mock(ConsoleUIDriver.class);
        MenuOption listBooks = mock(ListBooksOption.class);
        when(userEnters1.readInput()).thenReturn("1").thenReturn("quit");
        Menu menu = new Menu(Arrays.asList(listBooks), mock(InvalidOption.class), userEnters1);

        menu.interact();

        verify(listBooks, atLeastOnce()).select();
    }

    @Test
    void expectsCheckoutOptionSelectedWhenUserEnters2() {
        UIDriver userEnters2 = mock(ConsoleUIDriver.class);
        MenuOption listBooks = mock(ListBooksOption.class);
        MenuOption checkout = mock(CheckoutBookOption.class);
        when(userEnters2.readInput()).thenReturn("2").thenReturn("quit");
        Menu menu = new Menu(Arrays.asList(listBooks, checkout), mock(InvalidOption.class), userEnters2);

        menu.interact();

        verify(listBooks, never()).select();
        verify(checkout, atLeastOnce()).select();
    }

    @Test
    void expectsInvalidOptionSelectedWhenUserEntersInvalidInput() {
        UIDriver userEnters2 = mock(ConsoleUIDriver.class);
        MenuOption listBooks = mock(ListBooksOption.class);
        MenuOption checkout = mock(CheckoutBookOption.class);
        when(userEnters2.readInput()).thenReturn("random").thenReturn("quit");
        InvalidOption invalidOption = mock(InvalidOption.class);
        Menu menu = new Menu(Arrays.asList(listBooks, checkout), invalidOption, userEnters2);

        menu.interact();

        verify(listBooks, never()).select();
        verify(checkout, never()).select();
        verify(invalidOption, atLeastOnce()).select();
    }
}
