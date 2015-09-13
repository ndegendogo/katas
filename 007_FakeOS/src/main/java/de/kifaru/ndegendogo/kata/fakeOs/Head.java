package de.kifaru.ndegendogo.kata.fakeOs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.System;
import java.util.ArrayList;
import java.util.List;
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
            final List<String> stringsToPrint = new ArrayList<String>();
            int i = 0;
            for (final String filename: args) {
                final String leadingLines = readLeadingLinesFromFile(filename, withHeadline);
                stringsToPrint.add(leadingLines);
                if (++i < args.length) {
                    stringsToPrint.add("");
                }
            }
            for (String string: stringsToPrint) {
                out.println(string);
            }
        }
    }

    static String readLeadingLinesFromFile(final String filename, final boolean withHeadline) throws IOException, FileNotFoundException {
        try (
            final FileReader fileReader = new FileReader(filename);
            final BufferedReader bufferedReader = new BufferedReader(fileReader);
        ) {
            final Stream<String> headline = withHeadline ? Stream.of("==> " + filename + " <==") : Stream.empty();
            final Stream<String> leadingLines = readLeadingLines(bufferedReader);
            return Stream.concat(headline, leadingLines).collect(Collectors.joining(System.lineSeparator()));
        }
    }

    static void printLeadingLines(final BufferedReader bufferedReader, final PrintStream out) throws IOException {
        readLeadingLines(bufferedReader).forEachOrdered(line -> out.println(line));
    }

    static Stream<String> readLeadingLines(final BufferedReader bufferedReader) {
        return bufferedReader.lines().limit(MAX_NUMBER_OF_LINES);
    }

}
