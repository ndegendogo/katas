package de.kifaru.ndegendogo.kata.fakeOs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.function.Consumer;

public class TextFileOperation implements FileOperation {

    private final BufferedReader defaultInput;
    private final Consumer<BufferedReader> operation;

    public TextFileOperation(BufferedReader defaultInput, Consumer<BufferedReader> operation) {
        this.defaultInput = defaultInput;
        this.operation = operation;
    }

    public TextFileOperation(final InputStream in, Consumer<BufferedReader> process) {
        this.defaultInput = new BufferedReader(new InputStreamReader(in));
        this.operation = process;
    }

    @Override
    public void processFromDefault() {
        operation.accept(defaultInput);
    }

    @Override
    public void processFromFile(String filename) throws IOException {
        try (
            final FileReader fileReader = new FileReader(filename);
            final BufferedReader bufferedReader = new BufferedReader(fileReader);
        ) {
            operation.accept(bufferedReader);
        }
    }
}
