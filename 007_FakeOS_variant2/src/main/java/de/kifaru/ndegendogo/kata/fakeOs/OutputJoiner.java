package de.kifaru.ndegendogo.kata.fakeOs;

import java.io.PrintStream;

public class OutputJoiner extends PrintStream {

    private static final String DELIMITER = System.lineSeparator();

    private boolean isFollowing = false;
    
    public OutputJoiner(PrintStream out) {
        super(out);
    }

    public void print(String s) {
        if (isFollowing) {
            super.print(DELIMITER);
        }
        super.print(s);
        isFollowing = true;
    }
}
