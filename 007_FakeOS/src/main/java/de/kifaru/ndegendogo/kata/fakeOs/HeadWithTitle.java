package de.kifaru.ndegendogo.kata.fakeOs;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.Optional;

public class HeadWithTitle extends Head {

    HeadWithTitle(final BufferedReader defaultInput, final PrintStream output) {
        super(defaultInput, new OutputJoiner(output));
    }

    protected Optional<String> readLeadingLinesFromFile(final String filename) {
        Optional<String> optionalFileContents = super.readLeadingLinesFromFile(filename);
        if (optionalFileContents.isPresent()) {
            final String fileContents = optionalFileContents.get();
            final String result = String.join(System.lineSeparator(), buildHeadline(filename), fileContents);
            return Optional.of(result);
        } else {
            return optionalFileContents;
        }
    }

}
