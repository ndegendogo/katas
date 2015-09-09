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
        final StringBuilder inputBuilder = new StringBuilder();
        for (int i = 0; i < 2; i ++) {
            inputBuilder.append("2 lines" + System.lineSeparator());
        }
        final String inputString = inputBuilder.toString();
        final ByteArrayInputStream inputStream = new ByteArrayInputStream(inputString.getBytes());
        final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        final PrintStream out = new PrintStream(outputStream);
        Head.print2Lines(inputStream, out);
        final StringBuilder expectedBuilder = new StringBuilder();
        for (int i = 0; i < 2; i ++) {
            expectedBuilder.append("2 lines" + System.lineSeparator());
        }
        final String expected = expectedBuilder.toString(); 
        assertEquals(expected, outputStream.toString());
    }
}
