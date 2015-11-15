package de.kifaru.ndegendogo.kata.fakeOs;

import java.io.InputStream;
import java.io.PrintStream;

public class TailWithTitle extends Tail {


    TailWithTitle (final InputStream in, final PrintStream out) {
        super(true, in, out);
        setFileOperation(new TextFileOperation(in, this::printTrailingLines));
    }


}
