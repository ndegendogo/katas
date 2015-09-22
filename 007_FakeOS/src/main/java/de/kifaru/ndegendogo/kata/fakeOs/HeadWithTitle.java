package de.kifaru.ndegendogo.kata.fakeOs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Optional;

public class HeadWithTitle extends Head {

    HeadWithTitle(final PrintStream output) {
        super(new OutputJoiner(output));
    }

    protected Optional<String> readLeadingLinesFromFile(final String filename, boolean withHeadline) {
        try (
            final FileReader fileReader = new FileReader(filename);
            final BufferedReader bufferedReader = new BufferedReader(fileReader);
        ) {
            final String fileContents = readLeadingLines(bufferedReader);
            final String result = withHeadline 
                    ? String.join(System.lineSeparator(), buildHeadline(filename), fileContents)
                    : fileContents;
            return Optional.of(result);
        } catch (IOException e) {
            hasError = true;
            return Optional.empty();
        }
    }

}
