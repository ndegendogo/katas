package de.kifaru.ndegendogo.kata.fakeOs;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.Test;

public class TestHead {

    private final String inputString = "";
    private final String expected = "";
    
    @Test
    public void testPrintLines() throws IOException {
        final ByteArrayInputStream input = new ByteArrayInputStream(inputString.getBytes());
        final ByteArrayOutputStream output = new ByteArrayOutputStream();
        final PrintStream out = new PrintStream(output);
        Head.printLines(input, out);
        assertEquals(expected, output.toString());
    }
}
