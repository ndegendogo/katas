package de.kifaru.ndegendogo.kata.fakeOs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.System;
import java.util.concurrent.ArrayBlockingQueue;

public class Head extends BaseHeadTail {

    protected final boolean withTitle;
    protected final OutputJoiner output;
    
    Head(final boolean withTitle, final BufferedReader defaultInput, final PrintStream output) {
        this.withTitle = withTitle;
        this.output = new OutputJoiner(output);
        setFileOperation(new TextFileOperation(defaultInput, this::printLines));
    }

    Head (final boolean withTitle, final InputStream in, final PrintStream out) {
        this.withTitle = withTitle;
        this.output = new OutputJoiner(out);
        setFileOperation(new TextFileOperation(in, this::printLines));
    }

    public static void main(final String... args) {
        final FileCommand head = new Head((args.length >= 2), System.in, System.out);
        head.processAll(args);
    }

    protected void printLines(final BufferedReader bufferedReader) {
        final Iterable<String> lines = readLines(bufferedReader);
        if (withTitle) {
            output.print(buildTitle(currentFilename));
        }
        output.print(lines);
    }

    @Override
    protected void fillQueue(final ArrayBlockingQueue<String> queue, final BufferedReader buffered) throws IOException {
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
