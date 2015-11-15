package de.kifaru.ndegendogo.kata.fakeOs;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.PrintStream;

public class TailWithTitle extends Tail {


    TailWithTitle (final InputStream in, final PrintStream out) {
        super(in, out);
        setFileOperation(new TextFileOperation(in, this::printTrailingLines));
    }

    @Override
    protected void printTrailingLines(final BufferedReader bufferedReader) {
        final String result = readTrailingLines(bufferedReader);
        output.print(buildTitle(currentFilename));
        output.print(result);
    }

    private String buildTitle(final String filename) {
        return "==> " + filename + " <==";
    }

}
