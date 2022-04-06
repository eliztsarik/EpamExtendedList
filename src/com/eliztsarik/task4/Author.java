package com.eliztsarik.task4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Author {
    private String name;
    private short age;
    private List<Book> books;

    public String getName() {
        return name;
    }

    public short getAge() {
        return age;
    }

    public List<Book> getBooks() {
        return books;
    }

    public Author(String name, int age) {
        this.name = name;
        this.age = (short) age;
        this.books = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return age == author.age && Objects.equals(name, author.name) && books.equals(author.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "AUTHOR NAME = '" + name + '\'' +
                ", AUTHOR AGE = " + age +
                '}';
    }

    public List<Author> toList() {
        var result = new ArrayList<Author>();
        result.add(this);
        return result;
    }

    public static List<Author> toList(Author... authors) {
        return new ArrayList<>(Arrays.asList(authors));
    }

}
