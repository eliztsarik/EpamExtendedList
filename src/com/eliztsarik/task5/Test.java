package com.eliztsarik.task5;

import java.util.List;

public class Test {
    public static void main(String[] args) {

        List<Bed> beds = List.of(
                new Bed(23434.0, 2435, "1", 2, "White", false),
                new Bed(2345.6, 11232, "2", 1, "Black", false),
                new Bed(11346.0, 2345345, "3", 1, "Black", false),
                new Bed(254544.3, 52543, "4", 1, "White", false),
                new Bed(33452.8, 3354, "5", 1, "Black", false),
                new Bed(9234420.2, 845645, "6", 1, "Black", false),
                new Bed(124346.0, 25436, "7", 1, "Black", false),
                new Bed(13354.7, 1423, "8", 1, "Black", false),
                new Bed(63450.5, 123454, "9", 1, "Black", false),
                new Bed(335343.45, 82354, "10", 1, "Black", false),
                new Bed(8934.4, 32456, "1", 1, "Black", false),
                new Bed(34323.23, 34234, "12", 1, "Black", false),
                new Bed(23783.4, 1212, "13", 1, "Black", false)
        );

        var start = System.currentTimeMillis();
        var result = beds.stream().parallel().collect(BedCollector.toBedSums());
        System.out.println(result);
        var end = System.currentTimeMillis();
        System.out.println("Time: " + (end - start));

    }
}
