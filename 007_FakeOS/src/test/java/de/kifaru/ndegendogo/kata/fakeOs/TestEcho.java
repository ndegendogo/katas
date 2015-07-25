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
            {"singleArgument", "hello", new String[]{"hello"}},
            {"anotherSingleArgument", "world", new String[]{"world"}},
            {"twoArguments", "Hello world", new String[] {"Hello", "world"}},
            {"noArgument", "", new String[] {}},
            {"argumentWithTrailingSpace", "hello ", new String[] {"hello "}},
            {"emptyArgument", "", new String[] {""}},
        }
        );
    }

    private String[] arguments;
    private String expectedResult;
    
    public TestEcho(String nameOfTest, String expectedResult, String... arguments) {
        this.expectedResult = expectedResult;
        this.arguments = arguments;
    }
    
    @Test
    public void testJoinStrings() {
        assertEquals(expectedResult, Echo.joinStrings(arguments));
    }
    
}
