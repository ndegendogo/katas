package de.kifaru.ndegendogo.kata.fakeOs;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.System;
import java.util.StringJoiner;
import java.util.stream.Collector;

public class Head extends FileCommand {

    private static final int MAX_NUMBER_OF_LINES = 10;
    protected final PrintStream output;
    
    Head(final BufferedReader defaultInput, final PrintStream output) {
        this.output = output;
        setFileOperation(new TextFileOperation(defaultInput, this::printLeadingLines));
    }

    Head (final InputStream in, final PrintStream out) {
        this.output = out;
        setFileOperation(new TextFileOperation(in, this::printLeadingLines));
    }

    public static void main(final String... args) {
        final FileCommand head = (args.length >= 2) ? new HeadWithTitle(System.in, System.out) : new Head(System.in, System.out);
        head.processAll(args);
    }

    void printLeadingLines(final BufferedReader bufferedReader) {
        output.print(readLeadingLines(bufferedReader));
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
    
    @Override
    protected boolean hasError() {
        return (super.hasError() || output.checkError());
    }
}
