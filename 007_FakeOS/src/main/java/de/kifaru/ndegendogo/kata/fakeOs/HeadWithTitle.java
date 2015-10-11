package de.kifaru.ndegendogo.kata.fakeOs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.function.Consumer;

public class HeadWithTitle extends Head {
    
    String currentFilename;

    HeadWithTitle (final InputStream in, final PrintStream out) {
        super(in, new OutputJoiner(out));
        this.fileOperation = new TextFileOperation(in, this::printLeadingLines);
    }

    protected void processSingleFile(final String filename) throws IOException {
        currentFilename = filename;
        Consumer<BufferedReader> process = this::printLeadingLines;
        fileOperation.processFromFile(filename);
    }

    protected void printLeadingLines(final BufferedReader bufferedReader) {
        final String leadingLines = readLeadingLines(bufferedReader);
        output.print(buildTitle(currentFilename));
        output.print(leadingLines);
    }

    private String buildTitle(final String filename) {
        return "==> " + filename + " <==";
    }

}
