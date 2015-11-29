package de.kifaru.ndegendogo.kata.fakeOs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.concurrent.ArrayBlockingQueue;

public abstract class BaseHeadTail extends FileCommand {
    private static final int MAX_NUMBER_OF_LINES = 10;
    protected final boolean withTitle;
    protected final OutputJoiner output;

    BaseHeadTail(final boolean withTitle, final PrintStream output) {
        this.withTitle = withTitle;
        this.output = new OutputJoiner(output);
    }

    protected String buildTitle(final String filename) {
        return "==> " + filename + " <==";
    }

    protected Iterable<String> readLines(final BufferedReader buffered) {
        final ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(MAX_NUMBER_OF_LINES);
        try {
            fillQueue(queue, buffered);
        } catch (IOException e) {
            setError();
        }
        return queue;
    }

    abstract protected void fillQueue(final ArrayBlockingQueue<String> queue, final BufferedReader buffered) throws IOException;
}
