package de.kifaru.ndegendogo.kata.fakeOs;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.System;
import java.util.concurrent.ArrayBlockingQueue;

public class Head extends BaseHeadTail {

    Head(final boolean withTitle, final PrintStream out) {
        super(withTitle, out);
    }
    
    Head(final boolean withTitle, final BufferedReader defaultInput, final PrintStream out) {
        this(withTitle, out);
        setFileOperation(new TextFileOperation(defaultInput, this::printLines));
    }

    Head (final boolean withTitle, final InputStream in, final PrintStream out) {
        this(withTitle, out);
        setFileOperation(new TextFileOperation(in, this::printLines));
    }

    public static void main(final String... args) {
        final FileCommand head = new Head((args.length >= 2), System.in, System.out);
        head.processAll(args);
    }

    @Override
    protected boolean addTillFull(final ArrayBlockingQueue<String> collector, final String line) {
        collector.add(line);
        return collector.remainingCapacity() > 0;
    }
}
