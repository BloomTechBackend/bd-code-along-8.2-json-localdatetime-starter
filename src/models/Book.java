package models;

public class Book {

    private final String isbn;
    private final String title;
    private final Genre genre;
    private final String author;
    private final int publishedYear;
    private final String description;

    //TODO Step 3.1: make constructor private and build a Builder to replace the constructor.
    private Book(String isbn, String title, Genre genre, String author, int publishedYear, String description) {
        this.isbn = isbn;
        this.title = title;
        this.genre = genre;
        this.author = author;
        this.publishedYear = publishedYear;
        this.description = description;
    }

    public static class Builder {

        private String isbn;
        private String title;
        private Genre genre;
        private String author;
        private int publishedYear;
        private String description;

        public Builder isbn(String isbn) {
            this.isbn = isbn;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder genre(Genre genre) {
            this.genre = genre;
            return this;
        }

        public Builder author(String author) {
            this.author = author;
            return this;
        }

        public Builder publishedYear(int publishedYear) {
            this.publishedYear = publishedYear;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Book build() {
            return new Book(isbn, title, genre, author, publishedYear, description);
        }

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
