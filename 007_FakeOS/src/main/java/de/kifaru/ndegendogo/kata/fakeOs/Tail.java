package de.kifaru.ndegendogo.kata.fakeOs;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;


public class Tail {

    public static void main(final String... args) throws IOException {
        final InputStream in = System.in;
        final PrintStream out = System.out;
        
        new Head(in, out).processAll();
    }

}
