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

public class Head {

    private static final int MAX_NUMBER_OF_LINES = 10;
    final PrintStream out;
    private boolean hasError = false;

    Head(final PrintStream out) {
        this.out = out;
    }
    
    public static void main(final String... args) {
        final Head head = new Head(System.out);
        if (args.length == 0) {
            head.printLeadingLines(new BufferedReader(new InputStreamReader(System.in)));
        } else {
            head.printLeadingLinesFromFiles(args);
        }
        if (head.hasError()) {
            System.exit(1);
        }
    }

    void printLeadingLines(final BufferedReader bufferedReader) {
        out.print(readLeadingLines(bufferedReader));
    }

    private void printLeadingLinesFromFiles(final String... filenames) {
        try(final OutputJoiner outputJoiner = new OutputJoiner(out)) {
            final boolean withHeadline = filenames.length > 1;
            Arrays.asList(filenames)
                  .stream()
                  .map(filename -> readLeadingLinesFromFile(filename, withHeadline))
                  .filter(s -> s.isPresent())
                  .forEach(s -> outputJoiner.print(s.get()));
        }
    }

    private Optional<String> readLeadingLinesFromFile(final String filename, final boolean withHeadline) {
        try (
            final FileReader fileReader = new FileReader(filename);
            final BufferedReader bufferedReader = new BufferedReader(fileReader);
        ) {
            final String fileContents = readLeadingLines(bufferedReader);
            final String result = withHeadline 
                    ? String.join(System.lineSeparator(), buildHeadline(filename), fileContents)
                    : fileContents;
            return Optional.of(result);
        } catch (IOException e) {
            hasError = true;
            return Optional.empty();
        }
    }

    private String buildHeadline(final String filename) {
        return "==> " + filename + " <==";
    }

    private String readLeadingLines(final BufferedReader bufferedReader) {
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
    
    boolean hasError() {
        return (hasError || out.checkError());
    }
}
