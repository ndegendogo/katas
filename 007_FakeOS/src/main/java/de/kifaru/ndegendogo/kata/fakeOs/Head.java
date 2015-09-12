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
            int i = 0;
            for (final String filename: args) {
                final String headline = "==> " + filename + " <==";
                if (args.length > 1) {
                    out.println(headline);
                }
                try (
                    final FileReader fileReader = new FileReader(filename);
                    final BufferedReader bufferedReader = new BufferedReader(fileReader);
                ) {
                    final Stream<String> lines = bufferedReader.lines();
                    final Stream<String> limitedLines = limitLines(lines);
                    limitedLines.forEachOrdered(line -> out.println(line));
                }
                if (++i < args.length) {
                    out.println();
                }
            }
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
