package de.kifaru.ndegendogo.kata.fakeOs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.concurrent.ArrayBlockingQueue;


public class Tail {
    private static final int MAX_NUMBER_OF_LINES = 10;
    private final PrintStream output;

    Tail(final PrintStream output) {
        this.output = output;
    }
    
    public static void main(final String... args) throws IOException {
        final InputStream in = System.in;
        final PrintStream out = System.out;
        
        new Tail(out).process(in);
    }

    void process(final InputStream in) throws IOException {
        try(final InputStreamReader reader = new InputStreamReader(in);
            final BufferedReader buffered = new BufferedReader(reader);
        ) {
            printTrailingLines(buffered);
        }
    }

    void printTrailingLines(final BufferedReader buffered) throws IOException {
        final ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(MAX_NUMBER_OF_LINES);
        String line;
        while ((line = buffered.readLine()) != null) {
            if (queue.remainingCapacity() == 0) {
                queue.remove();
            }
            queue.add(new String(line));
        }
        queue.forEach(output::println);
    }
}
