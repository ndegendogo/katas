package de.kifaru.ndegendogo.kata.fakeOs;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.function.Consumer;

public class BinaryFileOperation implements FileOperation {

    private final InputStream defaultInput;
    private final  Consumer<InputStream> operation;

    public BinaryFileOperation(InputStream defaultInput, Consumer<InputStream> operation) {
        this.defaultInput = defaultInput;
        this.operation = operation;
    }

    @Override
    public void processFromDefault() {
        operation.accept(defaultInput);
    }

    @Override
    public void processFromFile(String filename) throws IOException {
        try (FileInputStream input = new FileInputStream(filename);
                BufferedInputStream bufferedIn = new BufferedInputStream(input);
        ) {
            operation.accept(bufferedIn);
        }
    }
}
