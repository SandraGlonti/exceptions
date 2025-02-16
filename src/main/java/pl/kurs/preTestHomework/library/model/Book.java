package pl.kurs.preTestHomework.library.model;

import pl.kurs.preTestHomework.library.exception.EmptyFieldException;

public class Book {
    private String title;
    private String author;
    private int pages;
    private String isbn;
    private Category category;

    public Book(String title, String author, int pages, String isbn, String category)
            throws EmptyFieldException, IllegalArgumentException{
        if (title == null || title.isEmpty()) {
            throw new EmptyFieldException("Tytuł nie może być pusty.");
        }
        if (author == null || author.isEmpty()) {
            throw new EmptyFieldException("Autor nie może być pusty.");
        }
        if (pages <= 0) {
            throw new EmptyFieldException("Liczba stron musi być większa niż 0.");
        }
        if (isbn == null || isbn.isEmpty()) {
            throw new EmptyFieldException("ISBN nie może być puste.");
        }
        if (category == null || category.isEmpty()) {
            throw new EmptyFieldException("Kategoria nie może być pusta.");
        }
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.isbn = isbn;
        this.category = Category.fromString(category);
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Książka{" +
                "Tytuł: '" + title + '\'' +
                ", Autor: '" + author + '\'' +
                ", Ilość stron: " + pages +
                ", ISBN: '" + isbn + '\'' +
                ", Kategoria: " + category +
                '}';
    }

    public boolean matches(String title, String author) {
        return this.title.equalsIgnoreCase(title) && this.author.equalsIgnoreCase(author);
    }

    public boolean titleMatches(String title) {
        return this.title.equalsIgnoreCase(title);
    }

}
