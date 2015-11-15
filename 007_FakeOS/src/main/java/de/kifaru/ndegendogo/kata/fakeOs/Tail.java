package de.kifaru.ndegendogo.kata.fakeOs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.concurrent.ArrayBlockingQueue;


public class Tail extends FileCommand {
    private static final int MAX_NUMBER_OF_LINES = 10;
    private final PrintStream output;

    Tail(final InputStream in, final PrintStream output) {
        this.output = output;
        setFileOperation(new TextFileOperation(in, this::printTrailingLines));
    }
    
    public static void main(final String... args) throws IOException {
        final FileCommand tail = new Tail(System.in, System.out);
        tail.processAll(args);
    }

    void printTrailingLines(final BufferedReader buffered) {
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
        queue.forEach(output::println);
    }

    @Override
    protected boolean hasError() {
        return (super.hasError() || output.checkError());
    }
}
