package de.kifaru.ndegendogo.kata.fakeOs;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

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

    private String[] arguments;
    private String expectedResult;
    
    public TestEcho(String nameOfTest, String[] arguments, String expectedResult) {
        this.arguments = arguments;
        this.expectedResult = expectedResult;
    }
    
    @Test
    public void testJoinStrings() {
        assertEquals(expectedResult, Echo.joinStrings(arguments));
    }
    
}
