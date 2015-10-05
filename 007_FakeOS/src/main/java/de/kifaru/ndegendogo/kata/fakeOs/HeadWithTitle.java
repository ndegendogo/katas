package de.kifaru.ndegendogo.kata.fakeOs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class HeadWithTitle extends Head {

    HeadWithTitle (final InputStream in, final PrintStream out) {
        super(in, new OutputJoiner(out));
    }

    protected void processSingleFile(final String filename) {
        try (
            final FileReader fileReader = new FileReader(filename);
            final BufferedReader bufferedReader = new BufferedReader(fileReader);
        ) {
            final String leadingLines = readLeadingLines(bufferedReader);
            output.print(String.join(System.lineSeparator(), buildTitle(filename), leadingLines));
        } catch (IOException e) {
            setError();
        }
    }

    private String buildTitle(final String filename) {
        return "==> " + filename + " <==";
    }

}
