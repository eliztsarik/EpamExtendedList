package com.eliztsarik.task4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {

    public static void main(String[] args) {

        var author1 = new Author("Jane Austen", 32);
        var book1 = new Book("Pride and Prejudice", 150, author1.toList());
        author1.getBooks().add(book1);

        var author2 = new Author("Kathy Sierra", 62);
        var author3 = new Author("Bert Bates", 45);
        var book2 = new Book("Head First Java", 800, Author.toList(author2, author3));
        author2.getBooks().add(book2);
        author3.getBooks().add(book2);

        var author4 = new Author("Cay Horstmann", 80);
        var book3 = new Book("Core Java volume 1", 890, author4.toList());
        var book4 = new Book("Core Java volume 2", 170, author4.toList());
        author4.getBooks().add(book3);
        author4.getBooks().add(book4);

        var books = new ArrayList<>(Arrays.asList(book1, book2, book3, book4));
        var authors = new ArrayList<>(Arrays.asList(author1, author2, author3, author4));

        Supplier<Stream<Book>> streamOfBooks = books::stream;

        Predicate<Book> pagesPredicate = n -> n.getNumberOfPages() > 200;
        System.out.println("1 anyMatch");
        System.out.println(streamOfBooks.get().anyMatch(pagesPredicate));
        System.out.println("1 allMatch");
        System.out.println(streamOfBooks.get().allMatch(pagesPredicate));

        System.out.println("\n2");
        System.out.println("Max number of pages: " + streamOfBooks.get()
                .peek(val -> System.out.print(val.getTitle() + " - " + val.getNumberOfPages() + " pages\n"))
                .mapToInt(Book::getNumberOfPages)
                .max().orElse(-1));

        System.out.println("Min numbers of pages: " + streamOfBooks.get().mapToInt(Book::getNumberOfPages).min().orElse(-1));

        System.out.println("\n3 filter single author");
        System.out.println(streamOfBooks.get().filter(b -> b.getAuthors().size() == 1).collect(Collectors.toList()));

        System.out.println("\n4 sort by pages");
        System.out.println(streamOfBooks.get().sorted().collect(Collectors.toList()));

        System.out.println("\n4 sort by titles");
        System.out.println(streamOfBooks.get().sorted(Comparator.comparing(Book::getTitle)).collect(Collectors.toList()));

        System.out.println("\n5 get titles");
        System.out.println(streamOfBooks.get().map(Book::getTitle).collect(Collectors.toList()));

        System.out.println("\n6 print by forEach");
        streamOfBooks.get().map(Book::getTitle).forEach(System.out::println);

        System.out.println("\n7 distinct list of authors");
        System.out.println(streamOfBooks.get().parallel().flatMap(x -> x.getAuthors().stream()).distinct().collect(Collectors.toList()));


        var biggestBook = authors.stream()
                .filter(a -> a.getName().equals("Cay Horstmann"))
                .flatMap(author -> author.getBooks().stream())
                .max(Comparator.comparing(Book::getNumberOfPages)).orElseThrow(NoSuchElementException::new);

        System.out.println("\n8 optional of biggest book");
        System.out.println(biggestBook);


    }
}
