package com.eliztsarik;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class ExtendedList<T> extends ArrayList<T> {

    public List<T> map(Function<T, T> func) {
        var counter = 0;
        for (var e : this) {
            set(counter++, func.apply(e));
        }
        return this;
    }

    public void fill(int n, Supplier<T> sup) {
        var counter = 0;
        while (counter < n) {
            add(sup.get());
            counter++;
        }
    }

    public boolean forAll(Predicate<T> predicate) {
        for (var e : this) {
            if (!predicate.test(e)) {
                return false;
            }
        }
        return true;
    }

    public List<List<T>> partition(Predicate<T> predicate) {
        var predicateIsTrue = new ArrayList<T>();
        var predicateIsFalse = new ArrayList<T>();
        for (var e : this) {
            if (predicate.test(e)) {
                predicateIsTrue.add(e);
            } else {
                predicateIsFalse.add(e);
            }
        }
        var result = new ArrayList<List<T>>();
        result.add(predicateIsFalse);
        result.add(predicateIsTrue);
        return result;
    }

    public T reduce(BinaryOperator<T> accumulator, T identityElement) {
        T result = identityElement;
        for (T e : this) {
            result = accumulator.apply(result, e);
        }
        return result;
    }


    public static void main(String[] args) {
        //map
        var array = new ExtendedList<Integer>() {{
            add(12);
            add(-3);
            add(34);
            add(0);
            add(8);
            add(-1);
        }};
        var newArray = array.map(m -> m * m);
        System.out.println(newArray.toString());


        //fill
        var array2 = new ExtendedList<Integer>();
        array2.fill(25, () -> ThreadLocalRandom.current().nextInt(0, 101));
        System.out.println(array2);


        //forAll
        var array3 = new ExtendedList<Integer>();
        array3.fill(20, () -> ThreadLocalRandom.current().nextInt(0, 2000) * 2);
        System.out.println(array3);
        var isEven = array3.forAll(n -> n % 2 == 0);
        if (isEven) {
            System.out.println("IS EVEN");
        } else {
            System.out.println("IS ODD");
        }


        //partition
        var partitionArray = array3.partition(n -> n % 2 == 0);
        System.out.println("Predicate is false: " + partitionArray.get(0).toString());
        System.out.println("Predicate is true: " + partitionArray.get(1).toString());


        //reduce
        var array4 = new ExtendedList<Integer>();
        array4.add(2);
        array4.add(4);
        array4.add(1);
        array4.add(6);
        System.out.println(array4.reduce((n, m) -> n * m, 1));
        System.out.println(array4.reduce(Integer::sum, 0));
    }
}
