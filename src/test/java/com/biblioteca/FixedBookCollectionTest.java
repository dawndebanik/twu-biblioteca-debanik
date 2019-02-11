package com.biblioteca;

import com.biblioteca.entities.*;
import com.biblioteca.exceptions.BookDoesNotBelongHereException;
import com.biblioteca.exceptions.BookNotAvailableException;
import com.biblioteca.exceptions.ItemNotAvailableException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// represents a collection of books which
// is decided beforehand
class FixedBookCollectionTest {
    @Test
    void expectsFixedCollectionOfBooksToBeReturned() {
        BookCollection fixedCollection = new FixedBookCollection();
        List<Book> expectedBooks = Arrays.asList(
                new Book("War and Peace", "Leo Tolstoy", "1867"),
                new Book("To Kill a Mockingbird", "Harper Lee", "1960"),
                new Book("Kafka on the Shore", "Haruki Murakami", "2002"),
                new Book("Nineteen Eighty-Four", "George Orwell", "1949"));

        List<Item> actualBooks = fixedCollection.getAvailable();

        assertEquals(expectedBooks.size(), actualBooks.size());
        for (int index = 0; index < actualBooks.size(); index++) {

            Book book = (Book) actualBooks.get(index);
            assertEquals(expectedBooks.get(index).name(), book.name());
        }
    }

    @Test
    void expectsBookToBeUnavailableAfterCheckout() throws ItemNotAvailableException {
        BookCollection fixedCollection = new FixedBookCollection();
        String bookName = "War and Peace";

        fixedCollection.remove(bookName);

        for (Item bookItem : fixedCollection.getAvailable()) {
            Book book = (Book) bookItem;
            assertNotEquals("War and Peace", book.name());
        }
    }

    @Test
    void expectsUnsuccessfulRemovalWhenBookNotPresent() {
        BookCollection fixedCollection = new FixedBookCollection();
        String bookName = "Pride and Prejudice";

        assertThrows(BookNotAvailableException.class, () -> fixedCollection.remove(bookName));
    }

    @Test
    void expectsSuccessfulInsertionWhenBookWasCheckedOut() throws ItemNotAvailableException {
        BookCollection fixedCollection = new FixedBookCollection();
        String bookName = "War and Peace";
        fixedCollection.remove(bookName);

        assertDoesNotThrow(() -> fixedCollection.add(bookName));
    }

    @Test
    void expectsUnsuccessfulInsertionWhenBookWasNotCheckedOut() {
        BookCollection fixedCollection = new FixedBookCollection();
        String bookName = "Pride and Prejudice";

        assertThrows(BookDoesNotBelongHereException.class, () -> fixedCollection.add(bookName));
    }
}
