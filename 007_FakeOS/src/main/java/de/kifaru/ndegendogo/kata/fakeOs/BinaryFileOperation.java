package de.kifaru.ndegendogo.kata.fakeOs;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.function.Consumer;

public class BinaryFileOperation implements FileOperation {

    private final InputStream defaultInput;
    private final Consumer<InputStream> operation;

    public BinaryFileOperation(final InputStream defaultInput, final Consumer<InputStream> operation) {
        this.defaultInput = defaultInput;
        this.operation = operation;
    }

    @Override
    public void processFromDefault() {
        operation.accept(defaultInput);
    }

    @Override
    public void processFromFile(final String filename) throws IOException {
        try (
            final FileInputStream input = new FileInputStream(filename);
            final BufferedInputStream bufferedIn = new BufferedInputStream(input);
        ) {
            operation.accept(bufferedIn);
        }
    }
}
