package de.kifaru.ndegendogo.kata.fakeOs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;


public class Tail {

    public static void main(final String... args) throws IOException {
        final InputStream in = System.in;
        final PrintStream out = System.out;
        
        process(in, out);
    }

    static void process(final InputStream in, final PrintStream out) throws IOException {
        try(final InputStreamReader reader = new InputStreamReader(in);
            final BufferedReader buffered = new BufferedReader(reader);
        ) {
            final String line = buffered.readLine();
            if (line != null) {
                out.println(line);
                out.flush();
            }
        }
    }

}
