package de.kifaru.ndegendogo.kata.fakeOs;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestEcho {

    @Test
    public void singleArgument() {
        final String result = Echo.getResult("hello");
        assertEquals("hello", result);
    }

    @Test
    public void anotherSingleArgument() {
        final String result = Echo.getResult("world");
        assertEquals("world", result);
    }
    
    @Test
    public void twoArguments() {
        final String result = Echo.getResult("Hello", "world");
        assertEquals("Hello world", result);
    }

    @Test
    public void noArgument() {
        final String result = Echo.getResult();
        assertEquals("", result);
    }

    @Test
    public void argumentWithTrailingSpace() {
        final String result = Echo.getResult("hello ");
        assertEquals("hello ", result);
    }

    @Test
    public void emptyArgument() {
        final String result = Echo.getResult("");
        assertEquals("", result);
    }
}
