package de.kifaru.ndegendogo.kata.fakeOs;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Cat {
    

    private final OutputStream out;

    public Cat(OutputStream out) {
        this.out = out;
    }

    public static void main(final String... args) throws FileNotFoundException, IOException {
        Cat cat = new Cat(System.out);
        boolean result = true;
        final String[] filenames = cat.getFilenames(args);
        for (final String name:filenames) {
            if (!cat.printFile(name)) {
                result = false;
            }
        }
        if (!result) {
            System.exit(1);
        }
    }

    private String[] getFilenames(final String... args) {
        return (args.length == 0) ? new String[] {"-"} : args;
    }

    private boolean printFile(final String name) throws IOException {
        return isFromStdIn(name) ? copyStream(System.in, out) : copyFile(name, out);
    }

    private boolean isFromStdIn(final String name) {
        return "-".equals(name);
    }

    boolean copyFile(final String filename, final OutputStream out) throws IOException {
        try (FileInputStream input = new FileInputStream(filename);
            BufferedInputStream bufferedIn = new BufferedInputStream(input); 
        ) {
            return copyStream(bufferedIn, out);
        } catch (FileNotFoundException e) {
            return false;
        }
    }

    boolean copyStream(final InputStream from, final OutputStream out) throws IOException {
        int nextByte;
        while((nextByte = from.read()) != -1) {
            out.write(nextByte);
        }
        out.flush();
        return true;
    }

}
