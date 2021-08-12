package com.eliztsarik.task3;

public class Test {
    public static void main(String[] args) {
        ThreeFunction<Integer> intMultiplication = (val1, val2, val3) -> val1 * val2 * val3;
        ThreeFunction<String> stringConcatenation = (val1, val2, val3) -> val1 + " " + val2 + " " + val3;


        System.out.println(intMultiplication.display(20, 40, 60));
        System.out.println(stringConcatenation.display("Liza", "loves", "Java"));
    }
}
