package de.kifaru.ndegendogo.kata.fakeOs;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
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
    
    @SuppressWarnings("unused")
    private final String testName;
    private final String expectedContent;
    private final String filename;
    
    public TestCat(final String testName, final String expectedContent, final String filename) {
        this.testName = testName;
        this.expectedContent = expectedContent;
        this.filename = filename;
    }
    
    @Test
    public void testProcessSingleFile() throws IOException {
        final ByteArrayInputStream dummy = null;
        final ByteArrayOutputStream output = new ByteArrayOutputStream();
        FileCommand cat = new Cat(dummy, output);
        cat.processSingleFile(filename);
        assertFalse(cat.hasError());
        assertEquals(expectedContent, output.toString());
    }

    @Test
    public void testProcessDefault() throws IOException {
        final ByteArrayInputStream input = new ByteArrayInputStream(expectedContent.getBytes());
        final ByteArrayOutputStream output = new ByteArrayOutputStream();
        FileCommand cat = new Cat(input, output);
        cat.processDefault();
        assertFalse(cat.hasError());
        assertEquals(expectedContent, output.toString());
    }
}
