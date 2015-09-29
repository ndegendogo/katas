package de.kifaru.ndegendogo.kata.fakeOs;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

public class Cat extends FileCommand {

    private static final String DEFAULT_INPUT= "-";
    private final OutputStream output;
    
    public Cat(InputStream defaultInput, OutputStream output) {
        super(new DataSourceForBytes(defaultInput));
        this.output = output;
    }

    public static void main(final String... args) {
        final FileCommand cat = new Cat(System.in, System.out);
        cat.processAll(args);
    }

    void processDefault() {
        process(defaultInput);
    }

    void process(final DataSource source) {
        writeStreamToOutput(source.getInputStream());
    }

    protected void processMulti(final String... filenames) {
        Arrays.asList(filenames).stream()
            .forEach(name -> processSingle(name));
    }

    protected void processSingle(final String name) {
        if(DEFAULT_INPUT.equals(name)) {
            processDefault();
        } else {
            processSingleFile(name);
        }
    }

    void processSingleFile(final String filename)  {
        try (FileInputStream input = new FileInputStream(filename);
            BufferedInputStream bufferedIn = new BufferedInputStream(input); 
        ) {
            writeStreamToOutput(bufferedIn);
        } catch (IOException e) {
            setError();
        }
    }

    private void writeStreamToOutput(final InputStream input) {
        try {
            int nextByte;
            while((nextByte = input.read()) != -1) {
                output.write(nextByte);
            }
            output.flush();
        } catch (IOException e) {
            setError();
        }
    }
}
