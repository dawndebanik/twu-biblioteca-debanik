package com.biblioteca;

import java.util.Scanner;

// represents a medium to readInput/write data from the console
class ConsoleIODriver implements IODriver{
    Scanner scanner = new Scanner(System.in);

    @Override
    public void display(String message) {
        System.out.println(message);
    }

    @Override
    public String readInput() {
        return scanner.nextLine();
    }
}
