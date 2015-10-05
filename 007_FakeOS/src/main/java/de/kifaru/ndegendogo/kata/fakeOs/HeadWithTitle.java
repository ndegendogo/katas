package de.kifaru.ndegendogo.kata.fakeOs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Optional;

public class HeadWithTitle extends Head {

    HeadWithTitle (final InputStream in, final PrintStream out) {
        super(in, new OutputJoiner(out));
    }

    protected void processSingleFile(final String filename) {
        Optional<String> result;
        try (
            final FileReader fileReader = new FileReader(filename);
            final BufferedReader bufferedReader = new BufferedReader(fileReader);
        ) {
            result = Optional.of(readLeadingLines(bufferedReader));
        } catch (IOException e) {
            setError();
            result = Optional.empty();
        }
        final Optional<String> leadingLines = result;
        leadingLines.ifPresent(s -> output.print(String.join(System.lineSeparator(), buildTitle(filename), s)));
    }

    private String buildTitle(final String filename) {
        return "==> " + filename + " <==";
    }

}
