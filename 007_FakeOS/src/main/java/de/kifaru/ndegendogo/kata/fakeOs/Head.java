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
            printLeadingLines(out, new BufferedReader(new InputStreamReader(System.in)));
        } else {
            printLeadingLinesFromFiles(out, args);
        }
    }

    static void printLeadingLines(final PrintStream out, final BufferedReader bufferedReader) throws IOException {
        out.print(readLeadingLines(bufferedReader, false, null));
    }

    static void printLeadingLinesFromFiles(final PrintStream out, final String... filenames) {
        final boolean withHeadline = filenames.length > 1;
        final String result = Arrays.asList(filenames).stream()
                .map(filename -> readLeadingLinesFromFile(filename, withHeadline))
                .collect(Collectors.joining(System.lineSeparator()));
        out.print(result);
    }

    static String readLeadingLinesFromFile(final String filename, final boolean withHeadline) {
        try (
            final FileReader fileReader = new FileReader(filename);
            final BufferedReader bufferedReader = new BufferedReader(fileReader);
        ) {
            return readLeadingLines(bufferedReader, withHeadline, filename);
        } catch (IOException e) {
            return null;
        }
    }

    static String readLeadingLines(final BufferedReader bufferedReader, final boolean withHeadline,
            final String filename) {
        final Stream<String> headline = withHeadline ? Stream.of("==> " + filename + " <==") : Stream.empty();
        final Stream<String> leadingLines = bufferedReader.lines().limit(MAX_NUMBER_OF_LINES);
        return Stream.concat(headline, leadingLines)
                .map(s -> s + System.lineSeparator())
                .collect(Collectors.joining());
    }
}
