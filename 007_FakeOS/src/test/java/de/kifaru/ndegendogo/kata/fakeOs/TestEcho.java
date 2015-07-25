package de.kifaru.ndegendogo.kata.fakeOs;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestEcho {

    @Parameters(name = "{0}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
            {"singleArgument", new String[]{"hello"}, "hello"},
            {"anotherSingleArgument", new String[]{"world"}, "world"},
            {"twoArguments", new String[] {"Hello", "world"}, "Hello world"},
            {"noArgument", new String[] {}, ""},
            {"argumentWithTrailingSpace", new String[] {"hello "}, "hello "},
            {"emptyArgument", new String[] {""}, ""},
        }
        );
    }

    @Test
    public void testJoinStrings1() {
        assertEquals(expectedResult, Echo.joinStrings(arguments));
    }

    private String nameOfTest;
    private String[] arguments;
    private String expectedResult;
    
    public TestEcho(String nameOfTest, String[] arguments, String expectedResult) {
        this.nameOfTest = nameOfTest;
        this.arguments = arguments;
        this.expectedResult = expectedResult;
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
