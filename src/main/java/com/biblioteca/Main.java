package com.biblioteca;

import com.biblioteca.entities.FixedBookCollection;
import com.biblioteca.io.ConsoleIODriver;

public class Main {
    public static void main(String[] args) {
        BibliotecaApplication application =
                new BibliotecaApplication(
                        new FixedBookCollection(),
                        new ConsoleUI(new ConsoleIODriver()));

        application.run();
    }
}
