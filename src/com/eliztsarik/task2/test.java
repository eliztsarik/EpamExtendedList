package com.eliztsarik.task2;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.function.*;
import java.util.stream.Stream;

public class test {

    public static void main(String[] args) {

        SecureRandom random = new SecureRandom();
        Supplier<String> getRandomString = () -> new BigInteger(130, random).toString(32);
        Predicate<String> hasH = val -> val.contains("h");
        UnaryOperator<String> deleteAllDigits = val -> val.replaceAll("\\d", "");
        BinaryOperator<String> stringConcatenation = (val1, val2) -> val1 + val2;
        Consumer<String> printLength = val -> System.out.println("Length of the string is: " + val.length());

        MultiplicationInterface<String> multiplyStrings = (count, val) -> val.repeat(count);
        MultiplicationInterface<Double> multiplyDoubles = new MultiplicationInterface<>() {
            @Override
            public Double filter(int count, Double val) {
                Double res = 1.0;
                for (int i = 0; i < count; i++) {
                    res *= val;
                }
                return res;
            }
        };

        var result = Stream.generate(getRandomString).limit(20).filter(hasH).reduce(stringConcatenation).orElse("");
        System.out.println(result);
        printLength.accept(result);
        var resultWithoutDigits = deleteAllDigits.apply(result);
        System.out.println(resultWithoutDigits);

        System.out.println(multiplyStrings.filter(6, "Hello! "));


    }
}
