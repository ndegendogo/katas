package de.kifaru.ndegendogo.kata.fakeOs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.System;
import java.util.StringJoiner;
import java.util.stream.Collector;

public class Head implements FileCommand {

    private static final int MAX_NUMBER_OF_LINES = 10;
    private final BufferedReader defaultInput;
    protected final PrintStream output;
    private ErrorState errorState = new ErrorState();

    Head(final BufferedReader defaultInput, final PrintStream output) {
        this.defaultInput = defaultInput;
        this.output = output;
    }

    Head (final InputStream in, final PrintStream out) {
        this.defaultInput = new BufferedReader(new InputStreamReader(in));
        this.output = out;
    }

    public static void main(final String... args) {
        final Head head = (args.length >= 2) ? new HeadWithTitle(System.in, System.out) : new Head(System.in, System.out);
        final FileCommandProcessor commandProcessor = new FileCommandProcessor(head);
        commandProcessor.processAll(args);
        head.errorState.handleError();
    }

    public boolean isDefaultInput(final String name) {
        return false;
    }

    public void processDefault() {
        printLeadingLines(defaultInput);
    }

    void printLeadingLines(final BufferedReader bufferedReader) {
        output.print(readLeadingLines(bufferedReader));
    }

    public void processSingleFile(final String filename) {
        try (
            final FileReader fileReader = new FileReader(filename);
            final BufferedReader bufferedReader = new BufferedReader(fileReader);
        ) {
            printLeadingLines(bufferedReader);
        } catch (IOException e) {
            setError();
        }
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

    void setError() {
        errorState.setError();
    }

    boolean hasError() {
        return errorState.hasError() || output.checkError();
    }
}
