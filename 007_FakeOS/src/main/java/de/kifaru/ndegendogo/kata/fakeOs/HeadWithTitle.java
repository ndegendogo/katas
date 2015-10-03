package de.kifaru.ndegendogo.kata.fakeOs;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Optional;

public class HeadWithTitle extends Head {

    HeadWithTitle (final InputStream in, final PrintStream out) {
        super(in, new OutputJoiner(out));
    }

    protected void processSingleFile(final String filename) {
        final Optional<String> leadingLines = readLeadingLinesFromFile(filename);
        if (leadingLines.isPresent()) {
            output.print(String.join(System.lineSeparator(), buildTitle(filename), leadingLines.get()));
        }

    }

    private String buildTitle(final String filename) {
        return "==> " + filename + " <==";
    }

}
