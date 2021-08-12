package com.eliztsarik.task4;

import java.util.List;
import java.util.Objects;

public class Book implements Comparable<Book> {
    private final String title;
    private final int numberOfPages;
    private final List<Author> authors;

    public String getTitle() {
        return title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public Book(String title, int numberOfPages, List<Author> authors) {
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "Book: " +
                "TITLE = '" + title + '\'' +
                ", PAGES = " + numberOfPages +
                ", AUTHORS = " + authors.toString() +
                "}\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return numberOfPages == book.numberOfPages && Objects.equals(title, book.title) && Objects.equals(authors, book.authors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, numberOfPages, authors);
    }

    @Override
    public int compareTo(Book otherBook) {
        return Integer.compare(getNumberOfPages(), otherBook.getNumberOfPages());
    }
}
