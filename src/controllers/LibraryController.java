package controllers;

import models.Book;
import models.Genre;
import models.Library;

public class LibraryController {

    private Library library = new Library();

    public void loadBooks() {
        //TODO Step 3.2: Add the following books using the builder pattern
        /** Book 1
         * isbn: 9780060935467
         * title: To Kill a Mockingbird
         * genre: Thriller
         * author: Harper Lee
         * year: 1960
         */
        addBook(new Book.Builder()
                .isbn("9780060935467")
                .title("To Kill a Mockingbird")
                .genre(Genre.THRILLER)
                .author("Harper Lee")
                .publishedYear(1960)
                .build());

        /** Book 2
         * isbn: 9786075274973
         * title: The Art of War
         * author: Sun Tzu
         */
        addBook(new Book.Builder()
                .isbn("9786075274973")
                .title("The Art of War")
                .author("Sun Tzu")
                .build());

        /** Book 3
         * isbn: 9780201616224
         * title: The Pragmatic Programmer
         * author: Andy Hunt
         * year: 1999
         */
        addBook(new Book.Builder()
                .isbn("9780201616224")
                .title("The Pragmatic Programmer")
                .author("Andy Hunt")
                .publishedYear(1999)
                .build());
    }

    private void addBook(Book book) {
        library.addBook(book);
    }

    public Book[] getBooks() {
        return library.getBooks();
    }

}
