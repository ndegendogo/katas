package de.kifaru.ndegendogo.kata.fakeOs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.System;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Head extends FileCommand {

    private static final int MAX_NUMBER_OF_LINES = 10;
    protected final boolean withTitle;
    protected final PrintStream output;
    
    Head(final boolean withTitle, final BufferedReader defaultInput, final PrintStream output) {
        this.withTitle = withTitle;
        this.output = new OutputJoiner(output);
        setFileOperation(new TextFileOperation(defaultInput, this::printLeadingLines));
    }

    Head (final boolean withTitle, final InputStream in, final PrintStream out) {
        this.withTitle = withTitle;
        this.output = new OutputJoiner(out);
        setFileOperation(new TextFileOperation(in, this::printLeadingLines));
    }

    public static void main(final String... args) {
        final FileCommand head = new Head((args.length >= 2), System.in, System.out);
        head.processAll(args);
    }

    protected void printLeadingLines(final BufferedReader bufferedReader) {
        final Queue<String> leadingLines = readLeadingLines(bufferedReader);
        if (withTitle) {
            output.print(buildTitle(currentFilename));
        }
        for (String s: leadingLines) {
            output.print(s);
        }
        output.print("");
    }

    Queue<String> readLeadingLines(final BufferedReader buffered) {
        final ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(MAX_NUMBER_OF_LINES);
        try {
            fillQueue(queue, buffered);
        } catch (IOException e) {
            setError();
        }
        return queue;
    }

    void fillQueue(final ArrayBlockingQueue<String> queue, final BufferedReader buffered) throws IOException {
        String line;
        while ((line = buffered.readLine()) != null && queue.remainingCapacity() > 0) {
            queue.add(new String(line));
        }
    }

    
    @Override
    protected boolean hasError() {
        return (super.hasError() || output.checkError());
    }
}
