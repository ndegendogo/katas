package de.kifaru.ndegendogo.kata.fakeOs;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCat {

    @Test
    public void singleFileWithOneLine() {
        assertEquals("This is one line of text.\n", Cat.getContent("data/file1"));
    }
    
}
