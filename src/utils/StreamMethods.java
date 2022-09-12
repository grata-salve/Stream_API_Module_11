package utils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamMethods {
    public static String printStringsWithOddIndexes(List<String> strings) {
        return IntStream.range(0, strings.size()).filter(i -> i % 2 != 0)
                .mapToObj(s -> s + ". " + strings.get(s)).collect(Collectors.joining(", "));
    }

    public static List<String> sortedByReverseOrderPlusUpperCase(List<String> strings) {
        return strings.stream().map(String::toUpperCase)
                .sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

    public static String printNumbersFromStringArray(String[] numbers) {
        String s = Arrays.toString(numbers);
        int length = s.length();
        return Arrays.toString(Arrays.stream(s.substring(1, length - 1)
                .split(",.")).map(Integer::parseInt).sorted().toArray()).substring(1, length - 1);
    }

    public static Stream<Long> randomNumbersStream(long a, int c, double m, long seed) {
        long mLong = (long) m;
        return Stream.iterate(seed, x -> 1 + ((a * x + c) % mLong));
    }

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        List<T> temp = new ArrayList<>();
        List<T> f = first.collect(Collectors.toList());
        List<T> s = second.collect(Collectors.toList());

        long iterator = Math.min(f.size(), s.size());

        IntStream.range(0, s.size()).forEach(i -> {
            if (i < iterator) {
                temp.add(f.get(i));
                temp.add(s.get(i));
            }
        });

        return temp.stream();
    }
}
