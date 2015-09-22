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

    protected static final int MAX_NUMBER_OF_LINES = 10;
    final protected PrintStream output;
    protected boolean hasError = false;

    Head(final PrintStream output) {
        this.output = output;
    }
    
    public static void main(final String... args) {
        final Head head = (args.length >= 2) ? new HeadWithTitle(System.out) : new Head(System.out);
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
        output.print(readLeadingLines(bufferedReader));
    }

    private void printLeadingLinesFromFiles(final String... filenames) {
        final boolean withHeadline = filenames.length > 1;
        Arrays.asList(filenames)
              .stream()
              .map(filename -> readLeadingLinesFromFile(filename, withHeadline))
              .filter(s -> s.isPresent())
              .forEach(s -> output.print(s.get()));
    }

    protected Optional<String> readLeadingLinesFromFile(final String filename, boolean withHeadline) {
        try (
            final FileReader fileReader = new FileReader(filename);
            final BufferedReader bufferedReader = new BufferedReader(fileReader);
        ) {
            withHeadline = false;
            final String fileContents = readLeadingLines(bufferedReader);
            final String result = fileContents;
            return Optional.of(result);
        } catch (IOException e) {
            hasError = true;
            return Optional.empty();
        }
    }

    protected String buildHeadline(final String filename) {
        return "==> " + filename + " <==";
    }

    protected String readLeadingLines(final BufferedReader bufferedReader) {
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
        return (hasError || output.checkError());
    }
}
