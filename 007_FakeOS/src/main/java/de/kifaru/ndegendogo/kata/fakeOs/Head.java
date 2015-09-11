package de.kifaru.ndegendogo.kata.fakeOs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.System;
import java.util.stream.Stream;

public class Head {

    private static final int MAX_NUMBER_OF_LINES = 10;

    public static void main(final String... args) throws IOException {
        final PrintStream out = System.out;
        if (args.length == 0) {
            printLeadingLinesFromInput(out);
        } else {
            printLeadingLinesFromFile(args[0], out);
        }
    }

    static void printLeadingLinesFromInput(final PrintStream out) throws IOException {
        final InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        final BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        final Stream<String> lines = readLines(bufferedReader);
        printLeadingLines(lines, out);
    }

    static void printLeadingLinesFromFile(final String filename, final PrintStream out) throws IOException,
            FileNotFoundException {
        try (final FileReader fileReader = new FileReader(filename);
             final BufferedReader bufferedReader = new BufferedReader(fileReader);
             final Stream<String> lines = readLines(bufferedReader);
        ) {
            printLeadingLines(lines, out);
        }
    }

    static void printLeadingLines(final Stream<String> lines, final PrintStream out) throws IOException {
        final Stream<String> limitedLines = limitLines(lines);
        printLines(limitedLines, out);
    }

    static Stream<String> readLines(final BufferedReader bufferedReader) {
        return bufferedReader.lines();
    }

    static Stream<String> limitLines(final Stream<String> lines) {
        return lines.limit(MAX_NUMBER_OF_LINES);
    }

    static void printLines(final Stream<String> lines, final PrintStream out) {
        lines.forEachOrdered(line -> out.println(line));
    }

}
