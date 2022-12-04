package uz.raianov.library.models;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Book {

    private int id;

    @NotEmpty(message = "Book title must not be empty")
    @Size(min = 1, max = 100, message = "Book title must be between 1 and 100 characters")
    private String title;

    @NotEmpty(message = "Author's name must not be empty")
    @Size(min = 1, max = 100, message = "Author's name must be between 1 and 100 characters")
    private String author;

    @Max(value = 2023, message = "Enter a valid year")
    private int year;

    public Book() {

    }

    public Book(int id, String title, String author, int year, int person_id) {

        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
