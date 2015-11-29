package de.kifaru.ndegendogo.kata.fakeOs;

import java.io.PrintStream;

public class OutputJoiner extends PrintStream {

    private static final String DELIMITER = System.lineSeparator();

    private boolean isFollowing = false;
    
    public OutputJoiner(final PrintStream out) {
        super(out);
    }

    public void print(final String s) {
        if (isFollowing) {
            super.print(DELIMITER);
        }
        super.print(s);
        isFollowing = true;
    }

    void print(final Iterable<String> lines) {
        for (final String s: lines) {
            print(s);
        }
        print("");
    }
}
