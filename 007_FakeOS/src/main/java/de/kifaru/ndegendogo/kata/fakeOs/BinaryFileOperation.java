package de.kifaru.ndegendogo.kata.fakeOs;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.function.Consumer;

public class BinaryFileOperation implements FileOperation<InputStream> {

    private final InputStream defaultInput;

    public BinaryFileOperation(InputStream defaultInput) {
        this.defaultInput = defaultInput;
    }

    @Override
    public void processFromDefault(Consumer<InputStream> process) {
        process.accept(defaultInput);
    }

    @Override
    public void processFromFile(String filename, Consumer<InputStream> process) throws IOException {
        try (FileInputStream input = new FileInputStream(filename);
                BufferedInputStream bufferedIn = new BufferedInputStream(input);
        ) {
            process.accept(bufferedIn);
        }
    }
}
