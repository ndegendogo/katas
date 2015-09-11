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
        } else if (args.length == 1){
            printLeadingLinesFromFile(args[0], out);
        } else if (args.length == 2) {
            String filename = args[0];
            out.println("==> " + filename + " <==");
            printLeadingLinesFromFile(filename, out);
            out.println();
            filename = args[1];
            out.println("==> " + filename + " <==");
            printLeadingLinesFromFile(filename, out);
        }
    }

    static void printLeadingLinesFromInput(final PrintStream out) throws IOException {
        final Stream<String> lines = readLines();
        printLeadingLines(lines, out);
    }

    static void printLeadingLinesFromFile(final String filename, final PrintStream out) throws IOException,
            FileNotFoundException {
        try (
            final FileReader fileReader = new FileReader(filename);
            final BufferedReader bufferedReader = new BufferedReader(fileReader);
            final Stream<String> lines = bufferedReader.lines();
        ) {
            printLeadingLines(lines, out);
        }
    }

    static Stream<String> readLines() {
        final InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        final BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        return bufferedReader.lines();
    }

    static void printLeadingLines(final Stream<String> lines, final PrintStream out) throws IOException {
        final Stream<String> limitedLines = limitLines(lines);
        printLines(limitedLines, out);
    }

    static Stream<String> limitLines(final Stream<String> lines) {
        return lines.limit(MAX_NUMBER_OF_LINES);
    }

    static void printLines(final Stream<String> lines, final PrintStream out) {
        lines.forEachOrdered(line -> out.println(line));
    }

}
