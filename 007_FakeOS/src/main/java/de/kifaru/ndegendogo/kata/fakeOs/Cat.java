package de.kifaru.ndegendogo.kata.fakeOs;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Cat {

    private final OutputStream out;
    private boolean hasError = false;

    public Cat(OutputStream out) {
        this.out = out;
    }

    public static void main(final String... args) throws FileNotFoundException, IOException {
        Cat cat = new Cat(System.out);
        final String[] filenames = cat.getFilenames(args);
        for (final String name:filenames) {
            cat.printFile(name);
        }
        if (cat.hasError()) {
            System.exit(1);
        }
    }

    private String[] getFilenames(final String... args) {
        return (args.length == 0) ? new String[] {"-"} : args;
    }

    private void printFile(final String name) throws IOException {
        if(isFromStdIn(name)) {
            copyStream(System.in);
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
            out.write(nextByte);
        }
        out.flush();
    }

    boolean hasError() {
        return (hasError);
    }
}
