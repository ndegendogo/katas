package de.kifaru.ndegendogo.kata.fakeOs;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

public class Cat {

    private static final String DEFAULT_INPUT= "-";

    private final InputStream defaultInput;
    private final OutputStream output;
    private boolean hasError = false;

    public Cat(InputStream defaultInput, OutputStream output) {
        this.defaultInput = defaultInput;
        this.output = output;
    }

    public static void main(final String... args) {
        final Cat cat = new Cat(System.in, System.out);
        if (args.length == 0) {
            cat.processDefault();
        } else {
            cat.processAll(args);
        }
        if (cat.hasError()) {
            System.exit(1);
        }
    }

    private void processAll(final String... filenames) {
        Arrays.asList(filenames).stream()
            .forEach(name -> processSingle(name));
    }

    private void processSingle(final String name) {
        if(DEFAULT_INPUT.equals(name)) {
            processDefault();
        } else {
            processSingleFile(name);
        }
    }

    void processDefault() {
        writeStreamToOutput(defaultInput);
    }

    void processSingleFile(final String filename)  {
        try (FileInputStream input = new FileInputStream(filename);
            BufferedInputStream bufferedIn = new BufferedInputStream(input); 
        ) {
            writeStreamToOutput(bufferedIn);
        } catch (IOException e) {
            hasError = true;
        }
    }

    private void writeStreamToOutput(final InputStream source) {
        try {
            int nextByte;
            while((nextByte = source.read()) != -1) {
                output.write(nextByte);
            }
            output.flush();
        } catch (IOException e) {
            hasError = true;
        }
    }

    boolean hasError() {
        return (hasError);
    }
}
