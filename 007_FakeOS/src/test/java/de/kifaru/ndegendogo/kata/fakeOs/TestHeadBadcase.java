package de.kifaru.ndegendogo.kata.fakeOs;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.StringReader;

import org.junit.Test;

public class TestHeadBadcase {

    @Test
    public void test() {
        final String inputLines = "Line1" + System.lineSeparator() + "Line2" + System.lineSeparator();
        final StringReader stringReader = new StringReader(inputLines);
        final BufferedReader bufferedReader = new BufferedReader(stringReader);
        
        final MockOutputStream outputStream = new MockOutputStream();
        final PrintStream out = new PrintStream(outputStream);

        final Head head = new Head(out);
        try {
            head.printLeadingLines(out, bufferedReader);
            fail();
        } catch (Exception e) {
            // this is expected
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
