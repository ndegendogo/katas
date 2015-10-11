package de.kifaru.ndegendogo.kata.fakeOs;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.function.Consumer;

public class BinaryFileOperation implements FileOperation<InputStream> {

    private final InputStream defaultInput;
    private final  Consumer<InputStream> process;

    public BinaryFileOperation(InputStream defaultInput, Consumer<InputStream> process) {
        this.defaultInput = defaultInput;
        this.process = process;
    }

    @Override
    public void processFromDefault() {
        process.accept(defaultInput);
    }

    @Override
    public void processFromFile(String filename) throws IOException {
        try (FileInputStream input = new FileInputStream(filename);
                BufferedInputStream bufferedIn = new BufferedInputStream(input);
        ) {
            process.accept(bufferedIn);
        }
    }
}
