package de.kifaru.ndegendogo.kata.fakeOs;

import java.io.ByteArrayInputStream;

public class BaseTestHead {

    protected final String testName;
    protected final String[] inputLines;
    protected final String[] expectedLines;

    public BaseTestHead(final String testName, final String[] inputLines, final String[] expectedLines) {
        this.testName = testName;
        this.inputLines = inputLines;
        this.expectedLines = expectedLines;
    }

    protected String concatenateLines(final String[] lines) {
        final StringBuilder builder = new StringBuilder();
        for (int i = 0; i < lines.length; i ++) {
            builder.append(lines[i] + System.lineSeparator());
        }
        final String string = builder.toString();
        return string;
    }

    protected ByteArrayInputStream createInputStream() {
        final String input = concatenateLines(inputLines);
        final ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        return inputStream;
    }

}
