package de.kifaru.ndegendogo.kata.fakeOs;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;

public abstract class BaseHeadTail extends FileCommand {

    protected String buildTitle(final String filename) {
        return "==> " + filename + " <==";
    }

    abstract protected void fillQueue(final ArrayBlockingQueue<String> queue, final BufferedReader buffered) throws IOException;
}
