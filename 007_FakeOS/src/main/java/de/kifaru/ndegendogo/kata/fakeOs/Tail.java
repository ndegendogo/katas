package de.kifaru.ndegendogo.kata.fakeOs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;


public class Tail extends FileCommand {
    private static final int MAX_NUMBER_OF_LINES = 10;
    protected final boolean withTitle;
    protected final PrintStream output;

    Tail(final boolean withTitle, final InputStream in, final PrintStream output) {
        this.withTitle = withTitle;
        this.output = new OutputJoiner(output);
        setFileOperation(new TextFileOperation(in, this::printTrailingLines));
    }
    
    public static void main(final String... args) throws IOException {
        final FileCommand tail = new Tail((args.length >= 2), System.in, System.out);
        tail.processAll(args);
    }

    protected void printTrailingLines(final BufferedReader bufferedReader) {
        final Queue<String> trailingLines = readTrailingLines(bufferedReader);
        if (withTitle) {
            output.print(buildTitle(currentFilename));
        }
        for (String s: trailingLines) {
            output.print(s);
        }
        output.print("");
    }

    Queue<String> readTrailingLines(final BufferedReader buffered) {
        final ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(MAX_NUMBER_OF_LINES);
        String line;
        try {
            while ((line = buffered.readLine()) != null) {
                if (queue.remainingCapacity() == 0) {
                    queue.remove();
                }
                queue.add(new String(line));
            }
        } catch (IOException e) {
            setError();
        }
        return queue;
    }

    @Override
    protected boolean hasError() {
        return (super.hasError() || output.checkError());
    }
}
