package de.kifaru.ndegendogo.kata.fakeOs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.System;

public class Head {

    private static final int MAX_NUMBER_OF_LINES = 10;

    public static void main(final String... args) throws IOException {
        final InputStream in = System.in;
        final PrintStream out = System.out;
        printLines(in, out);
    }

    static void printLines(final InputStream in, final PrintStream out) throws IOException {
        final InputStreamReader reader = new InputStreamReader(in);
        final BufferedReader buffered = new BufferedReader(reader);
        String line;
        int lineCount = 0;
        while((line = buffered.readLine()) != null) {
            if (++lineCount <= MAX_NUMBER_OF_LINES) {
                out.println(line);
            }
        }
    }

}
