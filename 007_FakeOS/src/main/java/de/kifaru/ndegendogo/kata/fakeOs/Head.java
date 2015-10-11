package de.kifaru.ndegendogo.kata.fakeOs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.System;
import java.util.Arrays;
import java.util.StringJoiner;
import java.util.stream.Collector;

public class Head extends FileCommand {

    private static final int MAX_NUMBER_OF_LINES = 10;
    protected FileOperation fileOperation;
    protected final PrintStream output;
    
    Head(final BufferedReader defaultInput, final PrintStream output) {
        this.fileOperation = new TextFileOperation(defaultInput, this::printLeadingLines);
        this.output = output;
    }

    Head (final InputStream in, final PrintStream out) {
        this.fileOperation = new TextFileOperation(in, this::printLeadingLines);
        this.output = out;
    }

    public static void main(final String... args) {
        final Head head = (args.length >= 2) ? new HeadWithTitle(System.in, System.out) : new Head(System.in, System.out);
        head.processAll(args);
    }

    protected void processAll(final String... filenames) {
        if (filenames.length > 0) {
            processMulti(filenames);
        } else {
            processDefault();
        }
        handleError();
    }

    protected void processMulti(final String... filenames) {
        Arrays.asList(filenames).stream()
            .forEach(name -> processSingle(name));
    }

    protected void processSingle(final String name) {
        try {
            if(isDefaultInput(name)) {
                processDefault();
            } else {
                processSingleFile(name);
            }
        } catch (IOException e) {
            setError();
        }
    }

    protected boolean isDefaultInput(final String name) {
        return false;
    }

    protected void processDefault() {
        fileOperation.processFromDefault();
    }

    protected void process(final BufferedReader input) {
        printLeadingLines(input);
    }

    void printLeadingLines(final BufferedReader bufferedReader) {
        output.print(readLeadingLines(bufferedReader));
    }

    protected void processSingleFile(final String filename) throws IOException {
        fileOperation.processFromFile(filename);
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
    
    protected boolean hasError() {
        return (super.hasError() || output.checkError());
    }
}
