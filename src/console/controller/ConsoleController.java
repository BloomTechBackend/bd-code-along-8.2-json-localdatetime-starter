package console.controller;

import console.commands.CheckoutBook;
import console.commands.ListBooksCommand;
import console.commands.ReturnBookCommand;
import controllers.LibraryController;
import controllers.ReceiptController;
import controllers.WaitListController;
import models.Receipt;
import models.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ConsoleController {

    public static WaitListController waitlist = new WaitListController();
    public static LibraryController library = new LibraryController(Arrays.asList(waitlist));
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public void start() {
        print("Welcome to the Terminal Library System!");

        printOptions();

    }

    private void printOptions() {
        print("What would you like to do? (enter a number)");
        String[] options = {
                "Search books",
                "Checkout book",
                "Return book",
                "See what books I have checked out",
                "Read in last receipt",
                "Process returns"
        };

        for (int i = 0; i < options.length; i++) {
            print((i+1) + ": " + options[i]);
        }

        String readline;
        int input = 0;
        try {
            readline = reader.readLine();
            if (readline != null) {
                input = Integer.parseInt(readline);
            }
        } catch (IOException|NumberFormatException e) {
            print("That is not a valid number. Try again.");
            printOptions();
            return;
        }

        if (input == 1) {
            startSearchBooks();
        } else if (input == 2) {
            startCheckoutBook();
        } else if (input == 3) {
            startReturnBook();
        } else if (input == 4) {
            startShowMyBooks();
        } else if (input == 5) {
            startReadInLastReceipt();
        } else if (input == 6) {
            library.processCheckedInBooks();
        }

        printOptions();

    }

    private void startShowMyBooks() {
        ListBooksCommand.start(User.currentUser.getBooks());
    }

    private void startReadInLastReceipt() {
        try {
            Receipt receipt = ReceiptController.readInReceipt();
            print("Found receipt for the following book: " + receipt.getNewBooks().get(0).getTitle() );
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void startReturnBook() {
        try {
            ReturnBookCommand.start(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void startCheckoutBook() {
        try {
            CheckoutBook.start(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void startSearchBooks() {
        ListBooksCommand.start(library.getBooks());
    }

    private void print(String string) {
        System.out.println(string);
    }

}
