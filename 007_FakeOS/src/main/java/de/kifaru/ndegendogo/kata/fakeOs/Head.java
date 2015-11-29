package de.kifaru.ndegendogo.kata.fakeOs;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.System;
import java.util.concurrent.ArrayBlockingQueue;

public class Head extends BaseHeadTail {
    
    Head(final boolean withTitle, final BufferedReader defaultInput, final PrintStream output) {
        super(withTitle, output);
        setFileOperation(new TextFileOperation(defaultInput, this::printLines));
    }

    Head (final boolean withTitle, final InputStream in, final PrintStream out) {
        super(withTitle, out);
        setFileOperation(new TextFileOperation(in, this::printLines));
    }

    public static void main(final String... args) {
        final FileCommand head = new Head((args.length >= 2), System.in, System.out);
        head.processAll(args);
    }

    @Override
    protected boolean bufferLine(final String line, final ArrayBlockingQueue<String> queue) {
        queue.add(new String(line));
        return queue.remainingCapacity() > 0;
    }
}
