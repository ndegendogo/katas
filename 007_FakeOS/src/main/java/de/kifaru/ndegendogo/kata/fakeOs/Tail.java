package de.kifaru.ndegendogo.kata.fakeOs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.concurrent.ArrayBlockingQueue;


public class Tail extends FileCommand {
    private static final int MAX_NUMBER_OF_LINES = 10;
    protected final boolean withTitle;
    protected final PrintStream output;

    Tail(final boolean withTitle, final InputStream in, final PrintStream output) {
        this.withTitle = withTitle;
        this.output = new OutputJoiner(output);
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
        for (String s: lines) {
            output.print(s);
        }
        output.print("");
    }

    Iterable<String> readLines(final BufferedReader buffered) {
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
