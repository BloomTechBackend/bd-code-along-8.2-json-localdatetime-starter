package console.commands;

import com.github.freva.asciitable.AsciiTable;
import models.Book;

import java.util.ArrayList;
import java.util.List;

public class ListBooksCommand {

    public static void start(List<Book> books) {

        String[] headers = {"", "ISBN", "Title", "Author", "Rating", "Status"};
        List<String[]> data = new ArrayList<>();

        Book b;
        List<String> bookData;
        for (int i = 0; i < books.size(); i++) {
            b = books.get(i);
            bookData = new ArrayList<>();
            bookData.add((i + 1) + "");
            bookData.add(b.getIsbn());
            bookData.add(b.getTitle());
            bookData.add(b.getAuthor());
            bookData.add(b.getRating() + "");
            bookData.add(b.getState().name());
            data.add(bookData.toArray(new String[6]));
        }

        System.out.println(AsciiTable.getTable(headers, data.toArray(new String[data.size()][])));

    }
}
