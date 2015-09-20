package de.kifaru.ndegendogo.kata.fakeOs;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Cat {

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
            cat.copyFromDefault();
        } else {
            cat.printAllFiles(args);
        }
        if (cat.hasError()) {
            System.exit(1);
        }
    }

    void copyFromDefault() throws IOException {
        copyStream(defaultInput);
    }

    private void printAllFiles(final String... filenames) throws IOException {
        for (final String name:filenames) {
            printFile(name);
        }
    }

    private void printFile(final String name) throws IOException {
        if(isFromStdIn(name)) {
            copyStream(defaultInput);
        } else {
            copyFile(name);
        }
    }

    private boolean isFromStdIn(final String name) {
        return "-".equals(name);
    }

    void copyFile(final String filename) throws IOException {
        try (FileInputStream input = new FileInputStream(filename);
            BufferedInputStream bufferedIn = new BufferedInputStream(input); 
        ) {
            copyStream(bufferedIn);
        } catch (FileNotFoundException e) {
            hasError = true;
        }
    }

    void copyStream(final InputStream from) throws IOException {
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
