package com.eliztsarik.task2;

@FunctionalInterface
public interface MultiplicationInterface<T> {
    T filter(int count, T val);

    default String multiplyStrings(int count, String val) {
        return String.valueOf(val).repeat(count);
    }

    default Integer multipluInts(int count, Integer val) {
        for (int i = 0; i < count; i++) {
            val *= val;
        }
        return val;
    }

    static void printInfoAboutInterface() {
        System.out.println("Functional interface is written by me.");
        System.out.println("It takes int digit as a first parameter and value of generic type as second.");
        System.out.println("Produces given generic type.");
    }

    static void doSomething() {
        System.out.println("In doSomething");
    }
}
