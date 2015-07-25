package de.kifaru.ndegendogo.kata.fakeOs;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class TestEcho {

    @Test
    public void singleArgument() {
        final String result = Echo.joinStrings("hello");
        assertEquals("hello", result);
    }

    @Test
    public void anotherSingleArgument() {
        final String result = Echo.joinStrings("world");
        assertEquals("world", result);
    }
    
    @Test
    public void twoArguments() {
        final String result = Echo.joinStrings("Hello", "world");
        assertEquals("Hello world", result);
    }

    @Test
    public void noArgument() {
        final String result = Echo.joinStrings();
        assertEquals("", result);
    }

    @Test
    public void argumentWithTrailingSpace() {
        final String result = Echo.joinStrings("hello ");
        assertEquals("hello ", result);
    }

    @Test
    public void emptyArgument() {
        final String result = Echo.joinStrings("");
        assertEquals("", result);
    }
    
    @Test
    public void constructStream() {
        final List<String> list = Arrays.asList("Hello");
        final Stream<String> stream = list.stream();
        Object[] array = stream.toArray();
        assertEquals(1, array.length);
        assertEquals("Hello", array[0]);
    }
    
    @Test
    public void joinStream() {
        final List<String> list = Arrays.asList("Hello");
        final Stream<String> stream = list.stream();
        String result = stream.collect(Collectors.joining());
        assertEquals("Hello", result);
    }

    @Test
    public void joinStreamsWithDelimiters() {
        final List<String> list = Arrays.asList("Hello,", "world!");
        final Stream<String> stream = list.stream();
        String result = stream.collect(Collectors.joining(" "));
        assertEquals("Hello, world!", result);
    }
}
