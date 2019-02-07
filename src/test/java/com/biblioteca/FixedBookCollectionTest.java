package com.biblioteca;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

// represents a collection of books which
// is decided beforehand
class FixedBookCollectionTest {
    @Test
    void expectsFixedCollectionOfBooksToBeReturned() {
        BookCollection fixedCollection = new FixedBookCollection();
        List<Book> books = Arrays.asList(
                new Book("War and Peace", "Leo Tolstoy", "1867"),
                new Book("To Kill a Mockingbird", "Harper Lee", "1960")
        );

        assertEquals(books, fixedCollection.getAvailableBooks());
    }

    @Test
    void expectsBookToBeUnavailableAfterCheckout() {
        BookCollection fixedCollection = new FixedBookCollection();
        Book bookToCheckout = new Book("War and Peace", "Leo Tolstoy", "1867");
        List<Book> booksAvailableAfterCheckout = Collections.singletonList(
                new Book("To Kill a Mockingbird", "Harper Lee", "1960"));

        fixedCollection.checkOutBook(bookToCheckout);

        assertEquals(booksAvailableAfterCheckout, 
                fixedCollection.getAvailableBooks());
    }

    @Test
    void expectsProperBookToBeSelectedWithName() {
        BookCollection fixedCollection = new FixedBookCollection();
        String bookName = "War and Peace";

        Book expectedBook = new Book("War and Peace", "Leo Tolstoy", "1867");

        assertEquals(expectedBook, fixedCollection.getBookWithName(bookName));
    }
}
