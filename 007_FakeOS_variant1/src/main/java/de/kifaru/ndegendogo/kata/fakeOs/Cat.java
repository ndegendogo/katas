package de.kifaru.ndegendogo.kata.fakeOs;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.function.Consumer;

public class Cat extends FileCommand {

    private static final String DEFAULT_INPUT= "-";
    
    private final InputStream defaultInput;
    private final OutputStream output;
    
    public Cat(InputStream defaultInput, OutputStream output) {
        this.defaultInput = defaultInput;
        this.output = output;
    }

    public static void main(final String... args) {
        final Cat cat = new Cat(System.in, System.out);
        cat.processAll(args);
    }

    @Override
    protected boolean isDefaultInput(final String name) {
        return DEFAULT_INPUT.equals(name);
    }

    @Override
    protected void processDefault() {
        process(defaultInput);
    }

    private void process(final InputStream input) {
        writeStreamToOutput(input);
    }

    private void writeStreamToOutput(final InputStream source) {
        try {
            int nextByte;
            while((nextByte = source.read()) != -1) {
                output.write(nextByte);
            }
            output.flush();
        } catch (IOException e) {
            setError();
        }
    }

    @Override
    protected void processSingleFile(final String filename) {
        try {
            Consumer<InputStream> process = this::writeStreamToOutput;
            FileOperation(filename, process);
        } catch (IOException e) {
            setError();
        }
    }

    static void FileOperation(final String filename, final Consumer<InputStream> process) throws IOException {
        try (FileInputStream input = new FileInputStream(filename);
                BufferedInputStream bufferedIn = new BufferedInputStream(input);
        ) {
            process.accept(bufferedIn);
        }
    }


}
