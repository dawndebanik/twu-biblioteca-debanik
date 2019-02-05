package com.biblioteca;

// represents the library management system
class BibliotecaApplication {
    private static final String WELCOME_MESSAGE = "Welcome to Biblioteca Application!";
    private final IODriver ioDriver;

    BibliotecaApplication(IODriver ioDriver) {
        this.ioDriver = ioDriver;
    }

    void run() {
        ioDriver.display(WELCOME_MESSAGE);
    }
}
