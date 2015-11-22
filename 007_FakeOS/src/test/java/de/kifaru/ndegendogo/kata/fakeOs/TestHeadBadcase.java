package de.kifaru.ndegendogo.kata.fakeOs;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.StringReader;
import org.junit.Test;

public class TestHeadBadcase {

    @Test
    public void testBlockedOutput() {
        final String inputLines = "Line1" + System.lineSeparator() + "Line2" + System.lineSeparator();
        final StringReader stringReader = new StringReader(inputLines);
        final BufferedReader input = new BufferedReader(stringReader);
        
        final MockBlockedOutputStream blockedOutputStream = new MockBlockedOutputStream();
        final PrintStream blockedOutput = new PrintStream(blockedOutputStream);

        final Head head = new Head(false, input, blockedOutput);
        try {
            head.printLines(input);
            assertTrue(head.hasError());
        } catch (Exception e) {
            fail();
        }
    }
        
    @Test
    public void testBlockedInput() {
        final String inputLines = "Line1" + System.lineSeparator() + "Line2" + System.lineSeparator();
        final MockBlockedInputStream blockedReader = new MockBlockedInputStream(inputLines);
        final BufferedReader blockedInput = new BufferedReader(blockedReader);
        
        final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        final PrintStream output = new PrintStream(outputStream);
        
        final Head head = new Head(false, blockedInput, output);
        try {
            head.printLines(blockedInput);
            assertTrue(head.hasError());
        } catch (Exception e) {
            fail();
        }
    }
    
    private class MockBlockedInputStream extends StringReader {
        MockBlockedInputStream(final String input) {
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
    
    private class MockBlockedOutputStream extends OutputStream {
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
