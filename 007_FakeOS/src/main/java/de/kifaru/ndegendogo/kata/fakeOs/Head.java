package de.kifaru.ndegendogo.kata.fakeOs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.System;
import java.util.Arrays;
import java.util.Optional;
import java.util.StringJoiner;
import java.util.stream.Collector;
import java.util.stream.Stream;

public class Head {

    private static final int MAX_NUMBER_OF_LINES = 10;
    
    public static void main(final String... args) throws IOException {
        try {
            final PrintStream out = System.out;
            if (args.length == 0) {
                printLeadingLines(out, new BufferedReader(new InputStreamReader(System.in)));
            } else {
                printLeadingLinesFromFiles(out, args);
            }
        } catch (Exception e) {
            System.exit(1);
        }
    }

    static void printLeadingLines(final PrintStream out, final BufferedReader bufferedReader) throws IOException {
        out.print(readLeadingLines(bufferedReader));
    }

    private static void printLeadingLinesFromFiles(final PrintStream out, final String... filenames) throws IOException {
        final ErrorStatus error = new ErrorStatus();
        try(final OutputJoiner outputJoiner = new OutputJoiner(out)) {
            final boolean withHeadline = filenames.length > 1;
            Arrays.asList(filenames)
                  .stream()
                  .map(filename -> readLeadingLinesFromFile(filename, withHeadline, error))
                  .filter(s -> s.isPresent())
                  .forEach(s -> outputJoiner.print(s.get()));
        }
        error.checkError();
    }

    private static Optional<String> readLeadingLinesFromFile(final String filename, final boolean withHeadline, final ErrorStatus error) {
        try (
            final FileReader fileReader = new FileReader(filename);
            final BufferedReader bufferedReader = new BufferedReader(fileReader);
        ) {
            final String fileContents = readLeadingLines(bufferedReader);
            String result;
            if (withHeadline) {
                result = String.join(System.lineSeparator(), buildHeadline(filename), fileContents);
            } else {
                result = fileContents;
            }
            return Optional.of(result);
        } catch (IOException e) {
            error.mapException(e);
            return Optional.empty();
        }
    }

    private static String buildHeadline(final String filename) {
        return "==> " + filename + " <==";
    }

    private static String readLeadingLines(final BufferedReader bufferedReader) {
        final Collector<String, StringJoiner, String> joining = Collector.of(
                () -> new StringJoiner(System.lineSeparator(), "", System.lineSeparator()).setEmptyValue(""),
                (j, s) -> j.add(s),
                (j1, j2) -> j1.merge(j2),
                StringJoiner::toString
        );
        return bufferedReader.lines()
                .limit(MAX_NUMBER_OF_LINES)
                .collect(joining);
    }
}
