package de.kifaru.ndegendogo.kata.fakeOs;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Echo {

    public static void main(final String... args) {
        System.out.println(joinStrings(args));
    }

    static String joinStrings(final String... strings) {
        final Stream<String> stream = Arrays.stream(strings);
        return stream.collect(Collectors.joining(" "));
    }

}
