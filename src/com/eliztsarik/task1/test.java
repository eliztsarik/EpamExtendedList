package com.eliztsarik.task1;

import java.util.ArrayList;
import java.util.Comparator;

public class test {
    public static void main(String[] args) {

        var personList = new ArrayList<Person>();
        personList.add(new Person("Alex", 30));
        personList.add(new Person("Max", 20));
        personList.add(new Person("Liza", 5));
        personList.add(new Person("Alice", 67));
        personList.add(new Person("Mike", 8));

        Comparator<Person> nameComparator = Comparator.comparing(Person::getName);
        Comparator<Person> ageComparator = Comparator.comparing(Person::getAge);

        System.out.println("NAMES COMPARED:");
        personList.stream().sorted(nameComparator).forEach(person -> System.out.println(person.toString()));

        System.out.println("\nAGE COMPARED:");
        personList.stream().sorted(ageComparator).forEach(person -> System.out.println(person.toString()));
    }
}
