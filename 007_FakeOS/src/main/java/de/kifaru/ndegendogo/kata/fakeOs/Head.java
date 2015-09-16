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
import java.util.stream.Stream;

public class Head {

    private static final int MAX_NUMBER_OF_LINES = 10;
    private static boolean result = true;
    
    public static void main(final String... args) throws IOException {
        final PrintStream out = System.out;
        if (args.length == 0) {
            printLeadingLines(out, new BufferedReader(new InputStreamReader(System.in)));
        } else {
            if (!printLeadingLinesFromFiles(out, args)) {
                result = false;   
            }
        }
        if (!result) {
            System.exit(1);
        }
    }

    static void printLeadingLines(final PrintStream out, final BufferedReader bufferedReader) throws IOException {
        out.print(readLeadingLines(bufferedReader, Stream.empty()));
    }

    private static boolean printLeadingLinesFromFiles(final PrintStream out, final String... filenames) {
        try(final OutputJoiner outputJoiner = new OutputJoiner(out)) {
            final boolean withHeadline = filenames.length > 1;
            Arrays.asList(filenames)
                  .stream()
                  .map(filename -> {try { return readLeadingLinesFromFile(filename, withHeadline); } catch (RuntimeException e) {result = false; return null;}})
                  .forEach(s -> {if (s != null) outputJoiner.print(s); });
            return true;
        }
    }

    private static String readLeadingLinesFromFile(final String filename, final boolean withHeadline) {
        try (
            final FileReader fileReader = new FileReader(filename);
            final BufferedReader bufferedReader = new BufferedReader(fileReader);
        ) {
            final Stream<String> headline = withHeadline ? Stream.of("==> " + filename + " <==") : Stream.empty();
            return readLeadingLines(bufferedReader, headline);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String readLeadingLines(final BufferedReader bufferedReader, final Stream<String> headline) {
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
