package de.kifaru.ndegendogo.kata.fakeOs;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCat {

    @Test
    public void singleFileWithOneLine() {
        final String expectedContent = "This is one line of text.\n";
        final String filename = "data/file1";
        testContentOfFile(expectedContent, filename);
    }

    @Test
    public void anotherSingleFileWithSingleLine() {
        final String expectedContent = "This is another line of text.\n";
        final String filename = "data/file2";
        testContentOfFile(expectedContent, filename);
    }

    private void testContentOfFile(final String expectedContent, final String filename) {
        assertEquals(expectedContent, Cat.getContentOfFile(filename));
    }
}
