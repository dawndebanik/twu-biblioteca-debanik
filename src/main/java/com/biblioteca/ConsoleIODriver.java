package com.biblioteca;

// represents a medium to read/write data from the console
class ConsoleIODriver implements IODriver{
    @Override
    public void display(String message) {
        System.out.println(message);
    }

    @Override
    public String read() {
        return null;
    }
}
