package de.kifaru.ndegendogo.kata.fakeOs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.System;
import java.util.Arrays;
import java.util.StringJoiner;
import java.util.stream.Collector;
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

    private static void printLeadingLinesFromFiles(final PrintStream out, final String... filenames) {
        final boolean withHeadline = filenames.length > 1;
        out.print(Arrays.asList(filenames).stream()
                .map(filename -> readLeadingLinesFromFile(filename, withHeadline))
                .collect(Collectors.joining(System.lineSeparator())));
    }

    private static String readLeadingLinesFromFile(final String filename, final boolean withHeadline) {
        try (
            final FileReader fileReader = new FileReader(filename);
            final BufferedReader bufferedReader = new BufferedReader(fileReader);
        ) {
            return readLeadingLines(bufferedReader, withHeadline, filename);
        } catch (IOException e) {
            return null;
        }
    }

    private static String readLeadingLines(final BufferedReader bufferedReader, final boolean withHeadline,
            final String filename) {
        final Stream<String> headline = withHeadline ? Stream.of("==> " + filename + " <==") : Stream.empty();
        final Stream<String> leadingLines = bufferedReader.lines().limit(MAX_NUMBER_OF_LINES);
        final Collector<String, StringJoiner, String> joining = Collector.of(
                () -> new StringJoiner(System.lineSeparator(), "", System.lineSeparator()).setEmptyValue(""),
                (j, s) -> j.add(s),
                (j1, j2) -> j1.merge(j2),
                StringJoiner::toString
        );
        return Stream.concat(headline, leadingLines).collect(joining);
    }
}
