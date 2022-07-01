package console.commands;

import console.controller.ConsoleController;
import models.Book;
import models.User;

import java.io.BufferedReader;
import java.io.IOException;

public class ReturnBookCommand {
    public static void start(BufferedReader reader) throws IOException {
        ListBooksCommand.start(User.currentUser.getBooks());
        System.out.println("What is the isbn of the book you are returning?");
        String input = reader.readLine();

        for (Book b : User.currentUser.getBooks()) {
            if (b.getIsbn().equals(input)) {
                System.out.println(b.getTitle() + " has been returned.");
                ConsoleController.library.checkInBook(b);
                return;
            }
        }

        System.out.println("We could not find a book with that isbn.");
    }
}
