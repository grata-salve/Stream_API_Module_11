import utils.StreamMethods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>(Arrays.asList("Oleg", "Ivan", "Vlad", "Peter", "Max"));

        // Task 1
        System.out.println(StreamMethods.printStringsWithOddIndexes(strings));

        // Task 2
        System.out.println(StreamMethods.sortedByReverseOrderPlusUpperCase(strings));

        // Task 3
        String[] numbers = {"1, 2, 0", "4, 5"};
        System.out.println(StreamMethods.printNumbersFromStringArray(numbers));

        // Task 4
        Stream<Long> numbersStream = StreamMethods.randomNumbersStream(25214903917L, 11, Math.pow(2, 48), 10L);
        //numbersStream.forEach(System.out::println);

        // Task 5
        Stream<String> first = Stream.of("1", "2", "3", "4", "5", "6");
        Stream<String> second = Stream.of("A", "B", "C", "D", "E");
        Stream<String> mixed = StreamMethods.zip(first, second);
        System.out.println(mixed.collect(Collectors.toList()));
    }
}