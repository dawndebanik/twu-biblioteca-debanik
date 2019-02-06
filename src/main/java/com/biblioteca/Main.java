package com.biblioteca;

public class Main {
    public static void main(String[] args) {
        BibliotecaApplication application =
                new BibliotecaApplication(new ConsoleIODriver(), new StaticCollectionOfBooks());

        application.run();
    }
}
