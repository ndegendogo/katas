package de.kifaru.ndegendogo.kata.fakeOs;

import java.io.IOException;

public interface FileOperation {
    public void processFromDefault();
    public void processFromFile(final String filename) throws IOException;
}
