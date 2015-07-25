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
        testJoinStrings("hello", new String[] {"hello"});
    }

    @Test
    public void anotherSingleArgument() {
        testJoinStrings("world", new String[] {"world"});
    }
    
    @Test
    public void twoArguments() {
        testJoinStrings("Hello world", new String[] {"Hello", "world"});
    }

    @Test
    public void noArgument() {
        testJoinStrings("", new String[] {});
    }

    @Test
    public void argumentWithTrailingSpace() {
        testJoinStrings("hello ", new String[] {"hello "});
    }

    @Test
    public void emptyArgument() {
        testJoinStrings("", new String[] {""});
    }
    
    private void testJoinStrings(final String expectedResult, final String[] arguments) {
        assertEquals(expectedResult, Echo.joinStrings(arguments));
    }

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
