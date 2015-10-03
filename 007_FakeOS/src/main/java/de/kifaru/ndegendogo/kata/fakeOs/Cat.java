package de.kifaru.ndegendogo.kata.fakeOs;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

public class Cat extends FileCommand {

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
        cat.processAll(args);
    }

    protected void processAll(final String... filenames) {
        if (filenames.length == 0) {
            processDefault();
        } else {
            processMulti(filenames);
        }
        handleError();
    }

    protected void processDefault() {
        process(defaultInput);
    }

    private void process(final InputStream input) {
        writeStreamToOutput(input);
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

    private boolean isDefaultInput(final String name) {
        return DEFAULT_INPUT.equals(name);
    }

    protected void processSingleFile(final String filename)  {
        try (FileInputStream input = new FileInputStream(filename);
            BufferedInputStream bufferedIn = new BufferedInputStream(input); 
        ) {
            process(bufferedIn);
        } catch (IOException e) {
            setError();
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
            setError();
        }
    }

    protected boolean setError() {
        return hasError = true;
    }

    protected boolean hasError() {
        return (hasError);
    }

    protected void handleError() {
        if (hasError()) {
            System.exit(1);
        }
    }
}
