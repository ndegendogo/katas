package de.kifaru.ndegendogo.kata.fakeOs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.function.Consumer;

public class TextFileOperation implements FileOperation {

    private final BufferedReader defaultInput;
    private final Consumer<BufferedReader> process;

    public TextFileOperation(BufferedReader defaultInput, Consumer<BufferedReader> process) {
        this.defaultInput = defaultInput;
        this.process = process;
    }

    @Override
    public void processFromDefault() {
        process.accept(defaultInput);
    }

    @Override
    public void processFromFile(String filename) throws IOException {
        try (
            final FileReader fileReader = new FileReader(filename);
            final BufferedReader bufferedReader = new BufferedReader(fileReader);
        ) {
            process.accept(bufferedReader);
        }
    }
}
