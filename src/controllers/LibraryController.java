package controllers;

import models.Book;
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

        /** Book 2
         * isbn: 9786075274973
         * title: The Art of War
         * author: Sun Tzu
         */

        /** Book 3
         * isbn: 9780201616224
         * title: The Pragmatic Programmer
         * author: Andy Hunt
         * year: 1999
         */
    }

    private void addBook(Book book) {
        library.addBook(book);
    }

    public Book[] getBooks() {
        return library.getBooks();
    }

}
