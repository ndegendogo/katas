package de.kifaru.ndegendogo.kata.fakeOs;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.function.Consumer;

public class Cat extends FileCommand {

    private static final String DEFAULT_INPUT= "-";
    
    private final BinaryFileOperation fileOperation;
    private final InputStream defaultInput;
    private final OutputStream output;
    
    public Cat(InputStream defaultInput, OutputStream output) {
        this.fileOperation = new BinaryFileOperation(defaultInput);
        this.defaultInput = defaultInput;
        this.output = output;
    }

    public static void main(final String... args) {
        final Cat cat = new Cat(System.in, System.out);
        cat.processAll(args);
    }

    protected void processAll(final String... filenames) {
        if (filenames.length > 0) {
            processMulti(filenames);
        } else {
            processDefault();
        }
        handleError();
    }

    protected void processMulti(final String... filenames) {
        Arrays.asList(filenames).stream()
            .forEach(name -> processSingle(name));
    }

    protected void processSingle(final String name) {
        if(isDefaultInput(name)) {
            processDefault();
        } else {
            processSingleFile(name);
        }
    }

    protected boolean isDefaultInput(final String name) {
        return DEFAULT_INPUT.equals(name);
    }

    protected void processDefault() {
        fileOperation.processFromDefault(this::writeStreamToOutput);
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

    protected void processSingleFile(final String filename) {
        try {
            fileOperation.processFromFile(filename, this::writeStreamToOutput);
        } catch (IOException e) {
            setError();
        }
    }

}
