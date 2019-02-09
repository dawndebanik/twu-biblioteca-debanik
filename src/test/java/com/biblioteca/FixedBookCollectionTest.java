package com.biblioteca;

import com.biblioteca.entities.Book;
import com.biblioteca.entities.BookCollection;
import com.biblioteca.entities.FixedBookCollection;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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

        List<Book> actualBooks = fixedCollection.getAvailableBooks();

        assertEquals(expectedBooks.size(), actualBooks.size());
        for (int index = 0; index < actualBooks.size(); index++) {
            assertEquals(expectedBooks.get(index).name(), actualBooks.get(index).name());
        }
    }

    @Test
    void expectsBookToBeUnavailableAfterCheckout() throws BookNotAvailableException {
        BookCollection fixedCollection = new FixedBookCollection();
        String bookName = "War and Peace";

        fixedCollection.removeBook(bookName);

        for (Book book : fixedCollection.getAvailableBooks()) {
            assertNotEquals("War and Peace", book.name());
        }
    }

    @Test
    void expectsUnsuccessfulRemovalWhenBookNotPresent() {
        BookCollection fixedCollection = new FixedBookCollection();
        String bookName = "Pride and Prejudice";

        assertThrows(BookNotAvailableException.class, () -> fixedCollection.removeBook(bookName));
    }

    @Test
    void expectsSuccessfulInsertionWhenBookWasCheckedOut() throws BookNotAvailableException {
        BookCollection fixedCollection = new FixedBookCollection();
        String bookName = "War and Peace";
        fixedCollection.removeBook(bookName);

        assertDoesNotThrow(() -> fixedCollection.addBook(bookName));
    }

    @Test
    void expectsUnsuccessfulInsertionWhenBookWasNotCheckedOut() {
        BookCollection fixedCollection = new FixedBookCollection();
        String bookName = "Pride and Prejudice";

        assertThrows(BookDoesNotBelongHereException.class, () -> fixedCollection.addBook(bookName));
    }
}
