package controllers;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import models.Book;
import models.Library;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import java.io.*;
import java.net.URL;
import java.util.HashMap;

public class LibraryController {

    private Library library = new Library();

    public void loadBooks(String resourceName) {
        //TODO Step 2: read in book file from resources
        //TODO NOTE: isbn is index 5, authors is 7, publication year is 8, title is 9, average_rating is 12
        URL u = getClass().getClassLoader().getResource(resourceName);
        try {
            FileReader fReader = new FileReader(u.getFile());
            CSVReader reader = new CSVReader(fReader);

            String[] data = reader.readNext(); // read the header line, but ignore it
            data = reader.readNext();
            while (data != null) {
                addBook(new Book.Builder()
                        .isbn(data[5])
                        .author(data[7])
                        .publishedYear(data[8])
                        .title(data[9])
                        .rating(Float.parseFloat(data[12]))
                        .build()
                );
                data = reader.readNext();
            }

            fReader.close();
            reader.close();

        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }

        produceImportReport();
    }

    private void produceImportReport() {
        //TODO Step 3: Produce a report and write it to a file
        int[] ratingCounts = { 0, 0, 0, 0, 0};
        for (Book book : getBooks()) {
            int rating = Math.round(book.getRating());
            ratingCounts[rating - 1]++;
        }
        DefaultPieDataset data = new DefaultPieDataset();

        data.setValue("1", ratingCounts[0]);
        data.setValue("2", ratingCounts[1]);
        data.setValue("3", ratingCounts[2]);
        data.setValue("4", ratingCounts[3]);
        data.setValue("5", ratingCounts[4]);

        JFreeChart chart = ChartFactory.createPieChart("Rating Count", data);
        try {
            ChartUtils.saveChartAsPNG(new File("chart.png"), chart, 400, 300);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void addBook(Book book) {
        library.addBook(book);
    }

    public Book[] getBooks() {
        return library.getBooks();
    }

}
