package de.kifaru.ndegendogo.kata.fakeOs;

import java.io.IOException;
import java.util.function.Consumer;

public interface FileOperation<T> {
    public void processFromDefault(final Consumer<T> process);
    public void processFromFile(final String filename, final Consumer<T> process) throws IOException;
}
