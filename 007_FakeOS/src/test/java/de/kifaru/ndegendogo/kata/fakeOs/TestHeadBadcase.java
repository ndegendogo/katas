package de.kifaru.ndegendogo.kata.fakeOs;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.StringReader;
import java.io.UncheckedIOException;

import org.junit.Test;

public class TestHeadBadcase {

    @Test
    public void testBlockedOutput() {
        final String inputLines = "Line1" + System.lineSeparator() + "Line2" + System.lineSeparator();
        final StringReader stringReader = new StringReader(inputLines);
        final BufferedReader bufferedReader = new BufferedReader(stringReader);
        
        final MockOutputStream outputStream = new MockOutputStream();
        final PrintStream out = new PrintStream(outputStream);

        final Head head = new Head(bufferedReader, out);
        try {
            head.printLeadingLines(bufferedReader);
            assertTrue(head.hasError());
        } catch (Exception e) {
            fail();
        }
    }
        
    @Test
    public void testBlockedInput() {
        final String inputLines = "Line1" + System.lineSeparator() + "Line2" + System.lineSeparator();
        final MockInputStream stringReader = new MockInputStream(inputLines);
        final BufferedReader bufferedReader = new BufferedReader(stringReader);
        
        final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        final PrintStream out = new PrintStream(outputStream);
        
        final Head head = new Head(bufferedReader, out);
        try {
            head.printLeadingLines(bufferedReader);
            fail();
        } catch (UncheckedIOException e) {
            // This exception is expected.
            // The current implementation of Head does not catch any unchecked exceptions.
        } catch (Exception e) {
            fail();
        }
    }
    
    private class MockInputStream extends StringReader {
        MockInputStream(final String input) {
            super(input);
        }
        
        public int read() throws IOException {
            int result = super.read();
            if (result == '\n') {
                throw new IOException();
            }
            return result;
        }
        
        public int read(char[] cbuf, int off, int len) throws IOException {
            int result = super.read(cbuf, off, len);
            if (result >= 0) {
                if (new String(cbuf, off, result).indexOf('\n') >= 0) {
                    throw new IOException();
                }
            }
            return result;
        }
    }
    
    private class MockOutputStream extends OutputStream {
        final StringBuilder sink = new StringBuilder();        
        private int count = 0;
        
        @Override      
        public void write(int b) throws IOException {
            if (++count > 10) {
                throw new IOException();
            };
            sink.append((char)b);      
        }      
               
    }      
    
}
