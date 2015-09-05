package de.kifaru.ndegendogo.kata.fakeOs;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.Test;

public class TestHead {

    @Test
    public void testPrintLines() {
        final InputStream in = null;
        final PrintStream out = null;
        try {
            Head.printLines(in, out);
        } catch (IOException e) {
            fail();
        }
        fail();
    }
}
