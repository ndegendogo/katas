package de.kifaru.ndegendogo.kata.fakeOs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.System;
import java.util.stream.Stream;

public class Head {

    private static final int MAX_NUMBER_OF_LINES = 10;

    public static void main(final String... args) throws IOException {
        if (args.length == 0) {
            printHeadOfFile(System.in, System.out);
        } else {
            String filename = args[0];
            try (final FileReader fileReader = new FileReader(filename);
                 final BufferedReader bufferedReader = new BufferedReader(fileReader);
            ) {
                final Stream<String> lines = bufferedReader.lines();
                final Stream<String> limitedLines = limitLines(lines);
                printLines(limitedLines, System.out);
            }
        }
    }

    static void printHeadOfFile(final InputStream in, final PrintStream out) throws IOException {
        final InputStreamReader inputStreamReader = new InputStreamReader(in);
        final BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        final Stream<String> lines = readLines(bufferedReader);
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
