package de.kifaru.ndegendogo.kata.fakeOs;

import java.io.PrintStream;

public class OutputJoiner extends PrintStream {

    public OutputJoiner(PrintStream out) {
        super(out);
    }

    public void print(String s) {
        super.print(s);
    }
}
