package de.kifaru.ndegendogo.kata.fakeOs;

import java.io.PrintStream;

public class OutputJoiner extends PrintStream {

    private static final String DELIMITER = System.lineSeparator();

    private boolean following = false;
    
    public OutputJoiner(PrintStream out) {
        super(out);
    }

    public void print(String s) {
        if (following) {
            super.print(DELIMITER);
        }
        super.print(s);
        following = true;
    }
}
