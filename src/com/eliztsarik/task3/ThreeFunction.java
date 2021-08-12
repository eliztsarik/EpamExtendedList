package com.eliztsarik.task3;

@FunctionalInterface
public interface ThreeFunction<T> {
    T display(T val1, T val2, T val3);
}
