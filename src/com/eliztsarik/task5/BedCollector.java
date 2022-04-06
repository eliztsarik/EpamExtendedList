package com.eliztsarik.task5;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class BedCollector implements Collector<Bed, Map<String, Double>, String> {


    public static BedCollector toBedSums() {
        return new BedCollector();
    }

    @Override
    public Supplier<Map<String, Double>> supplier() {
        return HashMap::new;
    }

    @Override
    public BiConsumer<Map<String, Double>, Bed> accumulator() {
        return (map, val) -> map.put(val.getName(), val.getSum());
    }

    @Override
    public BinaryOperator<Map<String, Double>> combiner() {
        return (l1, l2) -> {
            l1.putAll(l2);
            return l1;
        };
    }

    @Override
    public Function<Map<String, Double>, String> finisher() {
        return (m) -> {
            var builder = new StringBuilder();
            for (var i : m.entrySet()) {
                builder.append(i.getKey() + ": " + Math.round(i.getValue()) + "\n");
            }
            return builder.toString();
        };
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Set.of(Characteristics.UNORDERED, Characteristics.CONCURRENT);
    }
}
