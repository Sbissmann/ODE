package at.uastw;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * In diesem File sollten keine Änderungen notwendig sein!
 * Führen Sie die Tests aus, um Ihre Lösung zu überprüfen.
 */
class LibrarySerdeTest {
    @Test
    public void testSerialization() {
        Serde serde = new LibrarySerde();
        Library library = new Library();
        library.setName("Public Library");
        library.setAddress("123 Main St.");

        Book book1 = new Book();
        book1.setTitle("Book 1");
        book1.setAuthor("Author 1");
        book1.setYearPublished(2000);

        Book book2 = new Book();
        book2.setTitle("Book 2");
        book2.setAuthor("Author 2");
        book2.setYearPublished(2005);

        library.setBooks(Arrays.asList(book1, book2));

        String expectedJson = "{\"name\":\"Public Library\",\"address\":\"123 Main St.\",\"books\":[{\"title\":\"Book 1\",\"author\":\"Author 1\",\"yearPublished\":2000},{\"title\":\"Book 2\",\"author\":\"Author 2\",\"yearPublished\":2005}]}";
        assertEquals(expectedJson, serde.serializeLibrary(library));
    }

    @Test
    public void testDeserialization() {
        Serde serde = new LibrarySerde();
        String libraryJson = "{\"name\":\"Public Library\",\"address\":\"123 Main St.\",\"books\":[{\"title\":\"Book 1\",\"author\":\"Author 1\",\"yearPublished\":2000},{\"title\":\"Book 2\",\"author\":\"Author 2\",\"yearPublished\":2005}]}";

        Library library = serde.deserializeLibrary(libraryJson);
        assertEquals("Public Library", library.getName());
        assertEquals("123 Main St.", library.getAddress());
        assertEquals(2, library.getBooks().size());

        Book book1 = library.getBooks().get(0);
        assertEquals("Book 1", book1.getTitle());
        assertEquals("Author 1", book1.getAuthor());
        assertEquals(2000, book1.getYearPublished());

        Book book2 = library.getBooks().get(1);
        assertEquals("Book 2", book2.getTitle());
        assertEquals("Author 2", book2.getAuthor());
        assertEquals(2005, book2.getYearPublished());
    }

}