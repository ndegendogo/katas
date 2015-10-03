package de.kifaru.ndegendogo.kata.fakeOs;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Optional;

public class HeadWithTitle extends Head {

    HeadWithTitle (final InputStream in, final PrintStream out) {
        super(in, new OutputJoiner(out));
    }

    protected Optional<String> readLeadingLinesFromFile(final String filename) {
        Optional<String> fileContents = super.readLeadingLinesFromFile(filename);
        if (fileContents.isPresent()) {
            final String fileContentsWithTitle = String.join(System.lineSeparator(), buildTitle(filename), fileContents.get());
            return Optional.of(fileContentsWithTitle);
        } else {
            return Optional.empty();
        }
    }

    private String buildTitle(final String filename) {
        return "==> " + filename + " <==";
    }

}
