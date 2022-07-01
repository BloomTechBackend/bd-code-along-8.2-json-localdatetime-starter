package controllers;

import models.Book;
import models.Receipt;
import models.User;

import java.io.IOException;

public class ReceiptController  {

    public static void produceReceiptFile(Book book) {
        Receipt receipt = buildReceipt(book);
        //TODO Step 1.1 - Write JSON to file
    }

    public static Receipt readInReceipt() throws IOException {
        //TODO Step 1.2 - Read JSON to file
        return null;
    }

    private static Receipt buildReceipt(Book book) {
        Receipt receipt = new Receipt(User.currentUser, book);
        //TODO Step 2.2 - Add dates to Receipt object
        return receipt;
    }


}
