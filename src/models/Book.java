package models;

public class Book {

    private final String isbn;
    private final String title;
    private final Genre genre;
    private final String author;
    private final int publishedYear;
    private final String description;

    //TODO Step 3.1: make constructor private and build a Builder to replace the constructor.
    public Book(String isbn, String title, Genre genre, String author, int publishedYear, String description) {
        this.isbn = isbn;
        this.title = title;
        this.genre = genre;
        this.author = author;
        this.publishedYear = publishedYear;
        this.description = description;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public Genre getGenre() {
        return genre;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public String getDescription() {
        return description;
    }
}
