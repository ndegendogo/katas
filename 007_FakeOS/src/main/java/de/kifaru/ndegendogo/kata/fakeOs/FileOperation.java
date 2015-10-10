package de.kifaru.ndegendogo.kata.fakeOs;

import java.util.function.Consumer;

public interface FileOperation<T> {
    public void processFromDefault(final Consumer<T> process);
    public void procesFromFile(final String filename, final Consumer<T> process);
}
