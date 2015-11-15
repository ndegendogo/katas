package de.kifaru.ndegendogo.kata.fakeOs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.concurrent.ArrayBlockingQueue;


public class Tail {
    private static final int MAX_NUMBER_OF_LINES = 10;

    public static void main(final String... args) throws IOException {
        final InputStream in = System.in;
        final PrintStream out = System.out;
        
        new Tail().process(in, out);
    }

    void process(final InputStream in, final PrintStream out) throws IOException {
        try(final InputStreamReader reader = new InputStreamReader(in);
            final BufferedReader buffered = new BufferedReader(reader);
        ) {
            final ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(MAX_NUMBER_OF_LINES);
            String line;
            while ((queue.remainingCapacity() > 0) && ((line = buffered.readLine()) != null)) {
                queue.add(new String(line));
            }
            while ((line = buffered.readLine()) != null) {
                queue.remove();
                queue.add(new String(line));
            }
            queue.forEach(out::println);
        }
    }
}
