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
        final String input = buildStringFromLines(inputLines);
        final ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        
        final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        final PrintStream out = new PrintStream(outputStream);
        Head.print2Lines(inputStream, out);
        
        final String[] expectedLines = {"2 lines", "2 lines"};
        final String expectedOutput = buildStringFromLines(expectedLines); 
        assertEquals(expectedOutput, outputStream.toString());
    }

    private String buildStringFromLines(final String[] lines) {
        final StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 2; i ++) {
            builder.append(lines[i] + System.lineSeparator());
        }
        final String string = builder.toString();
        return string;
    }
    
    
}
