package de.kifaru.ndegendogo.kata.fakeOs;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Cat implements FileCommand {

    private static final String DEFAULT_INPUT= "-";
    
    private final InputStream defaultInput;
    private final OutputStream output;
    private ErrorState errorState = new ErrorState();

    public Cat(final InputStream defaultInput, final OutputStream output) {
        this.defaultInput = defaultInput;
        this.output = output;
    }

    public static void main(final String... args) {
        final Cat cat = new Cat(System.in, System.out);
        final FileCommandProcessor commandProcessor = new FileCommandProcessor(cat);
        commandProcessor.processAll(args);
        cat.errorState.handleError();
    }

    public boolean isDefaultInput(final String name) {
        return DEFAULT_INPUT.equals(name);
    }

    public void processDefault() {
        writeStreamToOutput(defaultInput);
    }

    private void writeStreamToOutput(final InputStream source) {
        try {
            int nextByte;
            while((nextByte = source.read()) != -1) {
                output.write(nextByte);
            }
            output.flush();
        } catch (IOException e) {
            errorState.setError();
        }
    }

    public void processSingleFile(final String filename) {
        try (final FileInputStream input = new FileInputStream(filename);
             final BufferedInputStream bufferedIn = new BufferedInputStream(input);
        ) {
            writeStreamToOutput(bufferedIn);
        } catch (IOException e) {
            errorState.setError();
        }
    }

    boolean hasError() {
        return errorState.hasError();
    }
}
