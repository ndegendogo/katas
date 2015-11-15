package de.kifaru.ndegendogo.kata.fakeOs;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.PrintStream;

public class TailWithTitle extends Tail {


    TailWithTitle (final InputStream in, final PrintStream out) {
        super(true, in, out);
        setFileOperation(new TextFileOperation(in, this::printTrailingLines));
    }

    @Override
    protected void printTrailingLines(final BufferedReader bufferedReader) {
        final String result = readTrailingLines(bufferedReader);
        if (withTitle) {
            output.print(buildTitle(currentFilename));
        }
        output.print(result);
    }

}
