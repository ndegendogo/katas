package de.kifaru.ndegendogo.kata.fakeOs;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Cat extends FileCommand {

    private static final String DEFAULT_INPUT= "-";
    
    private final OutputStream output;
    
    public Cat(InputStream defaultInput, OutputStream output) {
        this.output = output;
        setFileOperation(new BinaryFileOperation(defaultInput, this::writeStreamToOutput));
    }

    public static void main(final String... args) {
        final FileCommand cat = new Cat(System.in, System.out);
        cat.processAll(args);
    }

    protected void processSingle(final String name) {
        if(DEFAULT_INPUT.equals(name)) {
            processDefault();
        } else {
            super.processSingle(name);
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
}
