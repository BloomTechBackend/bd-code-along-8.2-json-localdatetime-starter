import controllers.LibraryController;
import models.Book;
import models.Genre;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BookTest {

    @Test
    void testBookBuilderPattern() {
        LibraryController controller = new LibraryController();

        controller.loadBooks();

        assertTrue(controller.getBooks().length >= 2);
    }

    @Test
    void testBookConstructorIsPrivate() {
        boolean isConstructorPrivate = false;
        int constructorCount = 0;
        try {
            isConstructorPrivate = Modifier.isPrivate(Book.class.getDeclaredConstructor(String.class, String.class, Genre.class, String.class, int.class, String.class).getModifiers());
            constructorCount = Book.class.getConstructors().length;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        assertTrue(isConstructorPrivate);
        assertTrue(constructorCount == 1);
    }
}
