package de.kifaru.ndegendogo.kata.fakeOs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.System;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Head {

    private static final int MAX_NUMBER_OF_LINES = 10;

    public static void main(final String... args) throws IOException {
        final PrintStream out = System.out;
        if (args.length == 0) {
            printLeadingLines(new BufferedReader(new InputStreamReader(System.in)), out);
        } else {
            final boolean withHeadline = args.length > 1;
            final String result = Arrays.asList(args).stream()
                    .map(filename -> readLeadingLinesFromFile(filename, withHeadline))
                    .collect(Collectors.joining(System.lineSeparator()));
            out.print(result);
        }
    }

    static String readLeadingLinesFromFile(final String filename, final boolean withHeadline) {
        try (
            final FileReader fileReader = new FileReader(filename);
            final BufferedReader bufferedReader = new BufferedReader(fileReader);
        ) {
            return readLeadingLines(bufferedReader, filename, withHeadline);
        } catch (IOException e) {
            return null;
        }
    }

    static void printLeadingLines(final BufferedReader bufferedReader, final PrintStream out) throws IOException {
        bufferedReader.lines()
                .limit(MAX_NUMBER_OF_LINES)
                .map(s -> s + System.lineSeparator())
                .forEachOrdered(line -> out.print(line));
    }

    static String readLeadingLines(final BufferedReader bufferedReader, final String filename,
            final boolean withHeadline) {
        final Stream<String> headline = withHeadline ? Stream.of("==> " + filename + " <==" + System.lineSeparator()) : Stream.empty();
        final Stream<String> leadingLines = bufferedReader.lines()
                .limit(MAX_NUMBER_OF_LINES)
                .map(s -> s + System.lineSeparator());
        return Stream.concat(headline, leadingLines).collect(Collectors.joining());
    }
}
