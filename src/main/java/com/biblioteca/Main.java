package com.biblioteca;

import com.biblioteca.entities.BookCollection;
import com.biblioteca.entities.FixedBookCollection;
import com.biblioteca.entities.FixedMovieCollection;
import com.biblioteca.entities.MovieCollection;
import com.biblioteca.menu.*;
import com.biblioteca.menu.option.*;
import com.biblioteca.ui.ConsoleUIDriver;
import com.biblioteca.ui.UIDriver;

import java.util.ArrayList;
import java.util.List;

// launcher for the application
public class Main {
    private static BookCollection bookCollection = new FixedBookCollection();
    private static MovieCollection movieCollection = new FixedMovieCollection();
    private static UIDriver consoleDriver = new ConsoleUIDriver();
    private static Menu defaultMenu = defaultMenu();

    public static void main(String[] args) {
        Bibliotheca application =
                new Bibliotheca(consoleDriver, defaultMenu);

        application.run();
    }

    private static Menu defaultMenu() {
        MenuOption listBooks = new ListItemsOption("List books", bookCollection, consoleDriver);
        MenuOption checkoutBooks = new CheckoutOption("Checkout a book", bookCollection, consoleDriver);
        MenuOption returnBook = new ReturnOption("Return a book", bookCollection, consoleDriver);

        MenuOption listMovies = new ListItemsOption("List movies", movieCollection, consoleDriver);
        MenuOption checkoutMovies = new CheckoutOption("Checkout a movie", movieCollection, consoleDriver);
        MenuOption returnMovie = new ReturnOption("Return a movie", movieCollection, consoleDriver);

        MenuOption invalid = new InvalidOption("Select a valid option!", bookCollection, consoleDriver);

        List<MenuOption> options = new ArrayList<>();
        options.add(listBooks);
        options.add(checkoutBooks);
        options.add(returnBook);
        options.add(listMovies);
        options.add(checkoutMovies);
        options.add(returnMovie);

        return new Menu(options, invalid, consoleDriver);
    }
}
