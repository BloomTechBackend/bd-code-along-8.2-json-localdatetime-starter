package console.commands;

import console.controller.ConsoleController;
import models.Book;
import models.User;

import java.io.BufferedReader;
import java.io.IOException;

public class CheckoutBook {
    public static void start(BufferedReader reader) throws IOException {
        System.out.println("What is the ISBN of the book you are interested in?");
        String input = reader.readLine();
        for (Book b : ConsoleController.library.getBooks()) {
            if (b.getIsbn().equals(input)) {
                attemptToCheckout(b, reader);
                return;
            }
        }
        System.out.println("We couldn't find the book with the isbn you provided.");
    }

    private static void attemptToCheckout(Book b, BufferedReader reader) throws IOException {
        if (ConsoleController.library.checkoutBook(b)) {
            System.out.println(b.getTitle() + " has been checked out!");
            return;
        }

        System.out.println("That book is not available. Would you like to be added to the wait list? (y/n)");
        String input = reader.readLine();
        if (input.contains("y")) {
            ConsoleController.waitlist.addToWaitList(b, User.currentUser);
            System.out.println("You have been added to the wait list for " + b.getTitle());
        }
    }
}
