package de.kifaru.ndegendogo.kata.fakeOs;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCat {

    @Test
    public void singleFileWithOneLine() {
        assertEquals("This is one line of text.\n", Cat.getContentOfFile("data/file1"));
    }
    
    @Test
    public void anotherSingleFileWithSingleLine() {
        assertEquals("This is another line of text.\n", Cat.getContentOfFile("data/file2"));
    }
}
