package models;

import exceptions.BookNotFoundException;
import exceptions.MaximumBookCheckedOutException;

import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;

public class User {

    private final String id;
    private String name;
    private String password;
    private Book[] books;

    private static final int MAX_BOOKS = 10;

    public User(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.books = new Book[MAX_BOOKS];
    }

    /**
     * Validates that the password is valid before saving it to the user.
     * Validations include a minimum character count of 8 and that a number,
     * upper case letter, and symbol are included.
     * @param password - password to store
     * @return true if the password is successfully saved
     */
    public boolean validateAndSet(String password) {
        //TODO Step 2: Implement Password Validator using the builder pattern.
        return false;
    }

    public String getPassword() {
        return password;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Book[] getBooks() {
        return books;
    }

    /**
     * Adds the book to the user's books
     * @param book - book to be added
     * @throws MaximumBookCheckedOutException
     */
    public void addBook(Book book) throws MaximumBookCheckedOutException {
        if (Arrays.stream(this.books).count() >= MAX_BOOKS) {
            throw new MaximumBookCheckedOutException();
        }

        for (int i = 0; i < this.books.length; i++) {
            if (this.books[i] == null) {
                this.books[i] = book;
                break;
            }
        }
    }

    /**
     * Removes the book from the
     * @param book
     * @throws BookNotFoundException
     */
    public void removeBook(Book book) throws BookNotFoundException {
        for (int i = 0; i < this.books.length; i++) {
            if (Objects.equals(this.books[i].getIsbn(), book.getIsbn())) {
                this.books[i] = null;
                return;
            }
        }

        throw new BookNotFoundException();
    }
}
