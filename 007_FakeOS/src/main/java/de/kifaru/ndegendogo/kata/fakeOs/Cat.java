package de.kifaru.ndegendogo.kata.fakeOs;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Cat {

    private static final String DEFAULT_INPUT= "-";

    private final InputStream defaultInput;
    private final OutputStream output;
    private boolean hasError = false;

    public Cat(InputStream defaultInput, OutputStream output) {
        this.defaultInput = defaultInput;
        this.output = output;
    }

    public static void main(final String... args) throws FileNotFoundException, IOException {
        final Cat cat = new Cat(System.in, System.out);
        if (args.length == 0) {
            cat.processDefault();
        } else {
            cat.processAllFiles(args);
        }
        if (cat.hasError()) {
            System.exit(1);
        }
    }

    void processDefault() throws IOException {
        writeStreamToOutput(defaultInput);
    }

    private void processAllFiles(final String... filenames) throws IOException {
        for (final String name:filenames) {
            if(DEFAULT_INPUT.equals(name)) {
                processDefault();
            } else {
                processSingleFile(name);
            }
        }
    }

    void processSingleFile(final String filename) throws IOException {
        try (FileInputStream input = new FileInputStream(filename);
            BufferedInputStream bufferedIn = new BufferedInputStream(input); 
        ) {
            writeStreamToOutput(bufferedIn);
        } catch (FileNotFoundException e) {
            hasError = true;
        }
    }

    private void writeStreamToOutput(final InputStream from) throws IOException {
        int nextByte;
        while((nextByte = from.read()) != -1) {
            output.write(nextByte);
        }
        output.flush();
    }

    boolean hasError() {
        return (hasError);
    }
}
