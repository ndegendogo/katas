package de.kifaru.ndegendogo.kata.fakeOs;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Optional;

public class HeadWithTitle extends Head {

    HeadWithTitle (final InputStream in, final PrintStream out) {
        super(in, new OutputJoiner(out));
    }

    protected void processSingleFile(final String filename) {
        final Optional<String> fileContents = super.readLeadingLinesFromFile(filename);
        Optional<String> result;
        if (fileContents.isPresent()) {
            final String fileContentsWithTitle = String.join(System.lineSeparator(), buildTitle(filename), fileContents.get());
            result = Optional.of(fileContentsWithTitle);
        } else {
            result = Optional.empty();
        }

        final Optional<String> leadingLines = result;
        leadingLines.ifPresent(output::print);
    }

    private String buildTitle(final String filename) {
        return "==> " + filename + " <==";
    }

}
