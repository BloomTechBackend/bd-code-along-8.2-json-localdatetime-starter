package models;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    public void addBooks(List<Book> books) {
        for (Book b : books) {
            addBook(b);
        }
    }

}
