package controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import gson.LocalDateTimeAdapter;
import models.Book;
import models.Receipt;
import models.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class ReceiptController  {

    //TODO Step 1 - Write JSON to file
    //TODO Step 2.2 - Add dates to Receipt object

    public static void produceReceiptFile(Book book) {

        Receipt receipt = buildReceipt(book);

        String filename = "receipt.json";
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                .create();

        try {
            FileWriter writer = new FileWriter(filename);
            gson.toJson(receipt, writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Receipt buildReceipt(Book book) {
        Receipt receipt = new Receipt(User.currentUser, book);
        receipt.setCheckoutDate(LocalDateTime.now());
        receipt.setDueBackDate(LocalDateTime.now().plusWeeks(1));
        return receipt;
    }

    public static Receipt readInReceipt() throws IOException {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                .create();

        BufferedReader bufferedReader = new BufferedReader(new FileReader("receipt.json"));
        return gson.fromJson(bufferedReader, Receipt.class);
    }

}
