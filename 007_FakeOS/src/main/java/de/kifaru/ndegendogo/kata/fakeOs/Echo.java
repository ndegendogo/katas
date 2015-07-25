package de.kifaru.ndegendogo.kata.fakeOs;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Echo {

    public static void main(final String... args) {
        final String resultString = joinStrings(args);
        System.out.println(resultString);
    }

    static String joinStrings(final String... strings) {
        final Stream<String> stream = Arrays.stream(strings);
        return stream.collect(Collectors.joining(" "));
    }

}
