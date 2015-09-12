package de.kifaru.ndegendogo.kata.fakeOs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.System;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Head {

    private static final int MAX_NUMBER_OF_LINES = 10;

    public static void main(final String... args) throws IOException {
        final PrintStream out = System.out;
        if (args.length == 0) {
            printLeadingLinesFromInput(out);
        } else {
            final List<String> lines = Arrays.asList(args);
            final List<String> stringsToPrint = new ArrayList<String>();
            int i = 0;
            for (final String filename: lines) {
                final String headline = "==> " + filename + " <==";
                if (lines.size() > 1) {
                    stringsToPrint.add(headline);
                }
                final List<String> listOfLines = readLeadingLinesFromFile(filename);
                stringsToPrint.addAll(listOfLines);
                if (++i < lines.size()) {
                    stringsToPrint.add("");
                }
            }
            for (String string: stringsToPrint) {
                out.println(string);
            }
        }
    }

    static List<String> readLeadingLinesFromFile(final String filename) throws IOException, FileNotFoundException {
        try (
            final FileReader fileReader = new FileReader(filename);
            final BufferedReader bufferedReader = new BufferedReader(fileReader);
        ) {
            final Stream<String> lines = bufferedReader.lines();
            final Stream<String> limitedLines = limitLines(lines);
            return limitedLines.collect(Collectors.toList());
        }
    }

    private static void printLeadingLinesFromInput(final PrintStream out) throws IOException {
        final InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        final BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        printLeadingLines(bufferedReader, out);
    }

    static void printLeadingLines(final BufferedReader bufferedReader, final PrintStream out) throws IOException {
        final Stream<String> lines = bufferedReader.lines();
        final Stream<String> limitedLines = limitLines(lines);
        printLines(limitedLines, out);
    }

    private static Stream<String> limitLines(final Stream<String> lines) {
        return lines.limit(MAX_NUMBER_OF_LINES);
    }

    private static void printLines(final Stream<String> lines, final PrintStream out) {
        lines.forEachOrdered(line -> out.println(line));
    }

}
