package de.kifaru.ndegendogo.kata.fakeOs;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class TestStreams {

    @Test
    public void constructStream() {
        final List<String> list = Arrays.asList("Hello");
        final Stream<String> stream = list.stream();
        final Object[] array = stream.toArray();
        assertEquals(1, array.length);
        assertEquals("Hello", array[0]);
    }
    
    @Test
    public void joinStream() {
        final List<String> list = Arrays.asList("Hello");
        final Stream<String> stream = list.stream();
        final String result = stream.collect(Collectors.joining());
        assertEquals("Hello", result);
    }

    @Test
    public void joinStreamsWithDelimiters() {
        final List<String> list = Arrays.asList("Hello,", "world!");
        final Stream<String> stream = list.stream();
        final String result = stream.collect(Collectors.joining(" "));
        assertEquals("Hello, world!", result);
    }
}
