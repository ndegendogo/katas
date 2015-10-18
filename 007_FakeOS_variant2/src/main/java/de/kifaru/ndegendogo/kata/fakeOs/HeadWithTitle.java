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
    }

    public void processSingleFile(final String filename) {
        currentFilename = filename;
        Consumer<BufferedReader> process = this::printLeadingLines;
        try (
            final FileReader fileReader = new FileReader(filename);
            final BufferedReader bufferedReader = new BufferedReader(fileReader);
        ) {
            process.accept(bufferedReader);
        } catch (IOException e) {
            errorState.setError();
        }
    }

    protected void printLeadingLines(final BufferedReader bufferedReader) {
        final String leadingLines = readLeadingLines(bufferedReader);
        output.print(buildTitle(currentFilename));
        output.print(leadingLines);
        if (output.checkError()) {
            errorState.setError();
        }
    }

    private String buildTitle(final String filename) {
        return "==> " + filename + " <==";
    }

}
