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

public class Head extends FileCommand {

    private static final int MAX_NUMBER_OF_LINES = 10;
    private BufferedReader defaultInput;
    final private PrintStream output;
    
    Head(BufferedReader defaultInput, final PrintStream output) {
        this.defaultInput = defaultInput;
        this.output = output;
    }
    
    public static void main(final String... args) {
        final BufferedReader defaultInput = new BufferedReader(new InputStreamReader(System.in));
        final Head head = (args.length >= 2) ? new HeadWithTitle(defaultInput, System.out) : new Head(defaultInput, System.out);
        head.process(args);
    }

    protected void process(final String... filenames) {
        if (filenames.length == 0) {
            processDefault();
        } else {
            processAll(filenames);
        }
        handleError();
    }

    protected void processDefault() {
        printLeadingLines(defaultInput);
    }

    protected void processAll(final String... filenames) {
        printLeadingLinesFromFiles(filenames);
    }

    void printLeadingLines(final BufferedReader bufferedReader) {
        output.print(readLeadingLines(bufferedReader));
    }

    private void printLeadingLinesFromFiles(final String... filenames) {
        Arrays.asList(filenames)
              .stream()
              .map(filename -> readLeadingLinesFromFile(filename))
              .filter(s -> s.isPresent())
              .forEach(s -> output.print(s.get()));
    }

    protected Optional<String> readLeadingLinesFromFile(final String filename) {
        try (
            final FileReader fileReader = new FileReader(filename);
            final BufferedReader bufferedReader = new BufferedReader(fileReader);
        ) {
            return Optional.of(readLeadingLines(bufferedReader));
        } catch (IOException e) {
            setError();
            return Optional.empty();
        }
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
        return (super.hasError() || output.checkError());
    }
}
