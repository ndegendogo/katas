package de.kifaru.ndegendogo.kata.fakeOs;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.Test;

public class TestHeadSpecialTests {

    
    @Test
    public void testPrint2Lines() throws IOException {
        final String[] inputLines = {"2 lines", "2 lines"};
        final StringBuilder inputBuilder = new StringBuilder();
        for (int i = 0; i < 2; i ++) {
            inputBuilder.append(inputLines[i] + System.lineSeparator());
        }
        final String input = inputBuilder.toString();
        final ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        
        final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        final PrintStream out = new PrintStream(outputStream);
        Head.print2Lines(inputStream, out);
        
        final String[] expectedLines = {"2 lines", "2 lines"};
        final StringBuilder expectedBuilder = new StringBuilder();
        for (int i = 0; i < 2; i ++) {
            expectedBuilder.append(expectedLines[i] + System.lineSeparator());
        }
        final String expectedOutput = expectedBuilder.toString(); 
        assertEquals(expectedOutput, outputStream.toString());
    }
}
