import controllers.LibraryController;
import models.Library;
import validators.Validator;

public class App {

    public static void main(String[] args) {

        LibraryController library = new LibraryController();
        library.loadBooks();

    }
}
