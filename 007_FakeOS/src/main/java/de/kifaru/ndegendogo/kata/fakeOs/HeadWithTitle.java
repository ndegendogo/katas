package de.kifaru.ndegendogo.kata.fakeOs;

import java.io.InputStream;
import java.io.PrintStream;

public class HeadWithTitle extends Head {
    

    HeadWithTitle (final InputStream in, final PrintStream out) {
        super(true, in, new OutputJoiner(out));
        setFileOperation(new TextFileOperation(in, this::printLeadingLines));
    }


}
