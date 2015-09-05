package de.kifaru.ndegendogo.kata.fakeOs;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class TestHead {

    @Parameters(name = "{0}")
    public static Iterable<Object[]>data() {
        return Arrays.asList(new Object[][] {
            {"noLines", "", ""}
        });
    }
    
    private final String testName;
    private final String inputString;
    private final String expected;
    
    public TestHead(final String testName, final String inputString, final String expected) {
        this.testName = testName;
        this.inputString = inputString;
        this.expected = expected;
    }
    
    @Test
    public void testPrintLines() throws IOException {
        final ByteArrayInputStream input = new ByteArrayInputStream(inputString.getBytes());
        final ByteArrayOutputStream output = new ByteArrayOutputStream();
        final PrintStream out = new PrintStream(output);
        Head.printLines(input, out);
        assertEquals(expected, output.toString());
    }
}
