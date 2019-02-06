package com.biblioteca;

// represents the library management system
class BibliotecaApplication {
    private static final String WELCOME_MESSAGE = "Welcome to Biblioteca Application!\n";
    private static final String AVAILABLE_BOOKS_HEADER = "Available books:";

    private final IODriver ioDriver;
    private final BookCollection bookCollection;

    BibliotecaApplication(IODriver ioDriver, BookCollection bookCollection) {
        this.ioDriver = ioDriver;
        this.bookCollection = bookCollection;
    }

    void run() {
        ioDriver.display(WELCOME_MESSAGE);

        showMenu();

        String userChoice = ioDriver.readInput().trim();
        if (userChoice.equals("1")) {
            listBooks();
            return;
        }
        ioDriver.display("Select a valid option!");
    }

    private void showMenu() {
        ioDriver.display("1. List all books");
    }

    private void listBooks() {
        ioDriver.display(AVAILABLE_BOOKS_HEADER);
        ioDriver.display(bookCollection.representation());
    }
}
