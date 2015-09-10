package de.kifaru.ndegendogo.kata.fakeOs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.System;
import java.util.stream.Stream;

public class Head {

    private static final int MAX_NUMBER_OF_LINES = 10;

    public static void main(final String... args) throws IOException {
        final InputStream in = System.in;
        final PrintStream out = System.out;
        printFile(in, out);
    }

    static void printFile(final InputStream in, final PrintStream out) throws IOException {
        final Stream<String> lines = readLines(in);
        final Stream<String> limitedLines = limitLines(lines);
        limitedLines.forEachOrdered(line -> out.println(line));
    }

    static Stream<String> readLines(final InputStream in) {
        return new BufferedReader(new InputStreamReader(in)).lines();
    }

    static Stream<String> limitLines(final Stream<String> lines) {
        final Stream<String> limitedLines = lines.limit(MAX_NUMBER_OF_LINES);
        return limitedLines;
    }

}
