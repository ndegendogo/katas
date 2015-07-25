package de.kifaru.ndegendogo.kata.fakeOs;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Echo {

    public static void main(String... args) {
        final String resultString = getResult(args);
        System.out.println(resultString);
    }

    public static String getResult(String... args) {
        final Stream<String> stream = Arrays.stream(args);
        return stream.collect(Collectors.joining(" "));
    }

}
