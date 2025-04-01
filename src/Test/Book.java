/*
package Test;

import Module.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class BookTest {

    private Book book;

    @BeforeEach
    void setUp() {
        book = new Book("O Hobbit", 1937, "J.R.R. Tolkien", "Allen & Unwin", "123456789", true);
    }

    @Test
    void testGetAuthor() {
        assertEquals("J.R.R. Tolkien", book.getAuthor());
    }

    @Test
    void testSetAuthor() {
        book.setAuthor("George R.R. Martin");
        assertEquals("George R.R. Martin", book.getAuthor());
    }

    @Test
    void testGetPublisher() {
        assertEquals("Allen & Unwin", book.getPublisher());
    }

    @Test
    void testSetPublisher() {
        book.setPublisher("HarperCollins");
        assertEquals("HarperCollins", book.getPublisher());
    }

    @Test
    void testGetIsbn() {
        assertEquals("123456789", book.getIsbn());
    }

    @Test
    void testSetIsbn() {
        book.setIsbn("987654321");
        assertEquals("987654321", book.getIsbn());
    }

    @Test
    void testGetCopy() {
        assertTrue(book.getCopy());
    }

    @Test
    void testSetCopy() {
        book.setCopy(false);
        assertFalse(book.getCopy());
    }

    @Test
    void testToString() {
        String expected = ", Autor: J.R.R. Tolkien, Editora: Allen & Unwin, ISBN: 123456789, Cópia: Sim";
        assertEquals(expected, book.toString());
    }
}
*/