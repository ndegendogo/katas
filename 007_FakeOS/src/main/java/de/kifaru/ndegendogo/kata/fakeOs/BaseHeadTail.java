package de.kifaru.ndegendogo.kata.fakeOs;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;

public abstract class BaseHeadTail extends FileCommand {
    private static final int MAX_NUMBER_OF_LINES = 10;

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
