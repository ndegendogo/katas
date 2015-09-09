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
                {"noLines", "", ""},
                {"oneLine", "1 line" + System.lineSeparator(), "1 line" + System.lineSeparator()},
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
        final ByteArrayInputStream inputStream = new ByteArrayInputStream(inputString.getBytes());
        final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        final PrintStream out = new PrintStream(outputStream);
        Head.printLines(inputStream, out);
        assertEquals(expected, outputStream.toString());
    }
    
    @Test
    public void testPrint2Lines() throws IOException {
        final StringBuilder inputBuilder = new StringBuilder();
        for (int i = 0; i < 2; i ++) {
            inputBuilder.append("2 lines" + System.lineSeparator());
        }
        final String inputString = inputBuilder.toString();
        final ByteArrayInputStream inputStream = new ByteArrayInputStream(inputString.getBytes());
        final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        final PrintStream out = new PrintStream(outputStream);
        Head.printLines(inputStream, out);
        final StringBuilder expectedBuilder = new StringBuilder();
        for (int i = 0; i < 2; i ++) {
            expectedBuilder.append("2 lines" + System.lineSeparator());
        }
        final String expected = expectedBuilder.toString(); 
        assertEquals(expected, outputStream.toString());
    }
}
