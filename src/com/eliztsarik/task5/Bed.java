package com.eliztsarik.task5;

import java.util.Objects;

public class Bed {
    static final double PILLOW_COST = 2.0;
    static final double HEADBOARD_COST = 6.0;

    private double cost;
    private double count;
    private String name;
    private int pillowCount;
    private String color;
    private boolean hasHeadBoard;

    public Bed(double cost, double count, String name, int pillowCount, String color, boolean hasHeadBoard) {
        this.cost = cost;
        this.count = count;
        this.name = name;
        this.pillowCount = pillowCount;
        this.color = color;
        this.hasHeadBoard = hasHeadBoard;
    }

    public double getCost() {
        return cost;
    }

    public double getCount() {
        return count;
    }

    public String getName() {
        return name;
    }

    public int getPillowCount() {
        return pillowCount;
    }

    public String getColor() {
        return color;
    }

    public boolean isHasHeadBoard() {
        return hasHeadBoard;
    }

    public double getSum() {
        var headBoardSum = (hasHeadBoard) ? HEADBOARD_COST : 0.0;
        return (this.cost + this.pillowCount * PILLOW_COST + headBoardSum) * this.count;
    }

    @Override
    public String toString() {
        return "Bed{" +
                "cost=" + cost +
                ", count=" + count +
                ", name='" + name + '\'' +
                ", pillowCount=" + pillowCount +
                ", color='" + color + '\'' +
                ", hasHeadBoard=" + hasHeadBoard +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bed bed = (Bed) o;
        return Double.compare(bed.cost, cost) == 0 && Double.compare(bed.count, count) == 0 && pillowCount == bed.pillowCount && hasHeadBoard == bed.hasHeadBoard && Objects.equals(name, bed.name) && Objects.equals(color, bed.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cost, count, name, pillowCount, color, hasHeadBoard);
    }
}
