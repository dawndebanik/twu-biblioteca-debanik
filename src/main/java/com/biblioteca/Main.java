package com.biblioteca;

import com.biblioteca.entities.FixedBookCollection;

public class Main {
    public static void main(String[] args) {
        BibliotecaApplication application =
                new BibliotecaApplication(
                        new FixedBookCollection(),
                        new ConsoleUIDriver());

        application.run();
    }
}
