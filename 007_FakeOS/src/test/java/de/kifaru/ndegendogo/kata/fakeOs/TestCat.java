package de.kifaru.ndegendogo.kata.fakeOs;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class TestCat {

    @Parameters(name = "{0}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] {
            {"singleFileWithOneLine", "This is one line of text.\n", "data/file1"},
            {"anotherSingleFileWithSingleLine", "This is another line of text.\n", "data/file2"}
        });
    }
    
    private final String testName;
    private final String expectedContent;
    private final String filename;
    
    public TestCat(final String testName, final String expectedContent, final String filename) {
        this.testName = testName;
        this.expectedContent = expectedContent;
        this.filename = filename;
    }
    
    @Test
    public void testPrintFile() throws IOException {
        final ByteArrayOutputStream output = new ByteArrayOutputStream();
        Cat.copyFile(filename, output);
        assertEquals(expectedContent, output.toString());
    }
    
}
