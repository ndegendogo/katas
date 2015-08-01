package de.kifaru.ndegendogo.kata.fakeOs;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCat {

    @Test
    public void singleFileWithOneLine() {
        final String expectedContent = "This is one line of text.\n";
        final String filename = "data/file1";
        assertEquals(expectedContent, Cat.getContentOfFile(filename));
    }
    
    @Test
    public void anotherSingleFileWithSingleLine() {
        final String expectedContent = "This is another line of text.\n";
        final String filename = "data/file2";
        assertEquals(expectedContent, Cat.getContentOfFile(filename));
    }
}
