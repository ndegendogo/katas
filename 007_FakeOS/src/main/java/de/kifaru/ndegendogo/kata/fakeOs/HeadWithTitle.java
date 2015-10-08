package de.kifaru.ndegendogo.kata.fakeOs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class HeadWithTitle extends Head {
    
    String currentFilename;

    HeadWithTitle (final InputStream in, final PrintStream out) {
        super(in, new OutputJoiner(out));
    }

    protected void processSingleFile(final String filename) {
        currentFilename = filename;
        try (
            final FileReader fileReader = new FileReader(filename);
            final BufferedReader bufferedReader = new BufferedReader(fileReader);
        ) {
            printLeadingLines(bufferedReader);
        } catch (IOException e) {
            setError();
        }
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
