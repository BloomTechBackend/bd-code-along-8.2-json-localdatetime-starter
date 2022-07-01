package models;

import java.util.Arrays;
import java.util.List;

public class Receipt {

    private User user;
    private List<Book> newBooks;
    //TODO Step 2.1 - Add checkoutDate and dueBackDate

    public Receipt(User user, Book book) {
        this.user = user;
        this.newBooks = Arrays.asList(book);
    }

    public Receipt(User user, List<Book> book) {
        this.user = user;
        this.newBooks = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Book> getNewBooks() {
        return newBooks;
    }

    public void setNewBooks(List<Book> newBooks) {
        this.newBooks = newBooks;
    }

}
