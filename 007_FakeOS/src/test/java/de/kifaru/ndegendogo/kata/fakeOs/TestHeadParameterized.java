package de.kifaru.ndegendogo.kata.fakeOs;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class TestHeadParameterized extends BaseTestHead {

    @Parameters(name = "{0}")
    public static Iterable<Object[]>data() {
        return Arrays.asList(new Object[][] {
                {"noLines", new String[]{}, new String[]{}},
                {"oneLine", new String[]{"1 line"}, new String[]{"1 line"}},
                {"lessLinesThanHeadOutputs", new String[]{"2 lines", "2 lines"}, new String[]{"2 lines", "2 lines"}},
                {"equalLinesAsHeadOutputs", 
                    new String[]{
                        "line 1",
                        "line 2",
                        "line 3",
                        "line 4",
                        "line 5",
                        "line 6",
                        "line 7",
                        "line 8",
                        "line 9",
                        "line 10",
                    }, 
                    new String[]{
                        "line 1",
                        "line 2",
                        "line 3",
                        "line 4",
                        "line 5",
                        "line 6",
                        "line 7",
                        "line 8",
                        "line 9",
                        "line 10",
                    }
                },
        });
    }
    
    public TestHeadParameterized(final String testName, final String[] inputLines, final String[] expectedLines) {
        super(testName, inputLines, expectedLines);
    }
    
    @Test
    public void testPrintLines() throws IOException {
        final String input = concatenateLines(inputLines);
        final ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        
        final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        final PrintStream out = new PrintStream(outputStream);
        Head.printLines(inputStream, out);
        final String expectedOutput = concatenateLines(expectedLines);
        assertEquals(expectedOutput, outputStream.toString());
    }
}
