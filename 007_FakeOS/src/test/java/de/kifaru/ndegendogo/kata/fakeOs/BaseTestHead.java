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
        return builder.toString();
    }

    protected ByteArrayInputStream createInputStream() {
        final String input = concatenateLines(inputLines);
        return new ByteArrayInputStream(input.getBytes());
    }

}
