package com.biblioteca;

// represents the library management system
class BibliotecaApplication {
    private static final String WELCOME_MESSAGE =
            "Welcome to Biblioteca Application!\n";
    private static final String AVAILABLE_BOOKS_HEADER = "Available books:";

    private final IODriver ioDriver;
    private final BookCollection bookCollection;

    BibliotecaApplication(IODriver ioDriver, BookCollection bookCollection) {
        this.ioDriver = ioDriver;
        this.bookCollection = bookCollection;
    }

    void run() {
        ioDriver.display(WELCOME_MESSAGE);

        ioDriver.display(AVAILABLE_BOOKS_HEADER);
        ioDriver.display(bookCollection.representation());
    }
}
