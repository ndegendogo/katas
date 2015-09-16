package de.kifaru.ndegendogo.kata.fakeOs;

import java.io.PrintStream;

public class OutputJoiner extends PrintStream {

    private boolean notFirst = false;
    
    public OutputJoiner(PrintStream out) {
        super(out);
    }

    public void print(String s) {
        if (notFirst) {
            super.print(System.lineSeparator());
        }
        super.print(s);
        notFirst = true;
    }
}
