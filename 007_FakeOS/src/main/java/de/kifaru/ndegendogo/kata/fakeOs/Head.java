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
        } else {
            int i = 0;
            for (String filename: args) {
                i ++;
                out.println("==> " + filename + " <==");
                printLeadingLinesFromFile(filename, out);
                if (i < args.length) {
                    out.println();
                }
            }
        }
    }

    private static void printLeadingLinesFromInput(final PrintStream out) throws IOException {
        final Stream<String> lines = readLines();
        printLeadingLines(lines, out);
    }

    private static void printLeadingLinesFromFile(final String filename, final PrintStream out) throws IOException,
            FileNotFoundException {
        try (
            final FileReader fileReader = new FileReader(filename);
            final BufferedReader bufferedReader = new BufferedReader(fileReader);
            final Stream<String> lines = bufferedReader.lines();
        ) {
            printLeadingLines(lines, out);
        }
    }

    private static Stream<String> readLines() {
        final InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        final BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        return bufferedReader.lines();
    }

    static void printLeadingLines(final Stream<String> lines, final PrintStream out) throws IOException {
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
