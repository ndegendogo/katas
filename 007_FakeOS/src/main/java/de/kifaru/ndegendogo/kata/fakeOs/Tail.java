package de.kifaru.ndegendogo.kata.fakeOs;

import java.io.BufferedReader;
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
        while ((line = buffered.readLine()) != null) {
            if (queue.remainingCapacity() == 0) {
                queue.remove();
            }
            queue.add(new String(line));
        }
    }

    @Override
    protected boolean hasError() {
        return (super.hasError() || output.checkError());
    }
}
