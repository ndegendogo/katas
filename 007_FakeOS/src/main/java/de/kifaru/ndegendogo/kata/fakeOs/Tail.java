package de.kifaru.ndegendogo.kata.fakeOs;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.concurrent.ArrayBlockingQueue;


public class Tail extends BaseHeadTail {

    Tail(final boolean withTitle, final InputStream in, final PrintStream output) {
        super(withTitle, output);
        setFileOperation(new TextFileOperation(in, this::printLines));
    }
    
    public static void main(final String... args) throws IOException {
        final FileCommand tail = new Tail((args.length >= 2), System.in, System.out);
        tail.processAll(args);
    }

    @Override
    protected boolean collectLine(final ArrayBlockingQueue<String> collector, final String line) {
        if (collector.remainingCapacity() == 0) {
            collector.remove();
        }
        collector.add(new String(line));
        return true;
    }
}
