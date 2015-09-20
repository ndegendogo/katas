package de.kifaru.ndegendogo.kata.fakeOs;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Cat {

    public static void main(final String... args) throws FileNotFoundException, IOException {
        Cat cat = new Cat();
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
        return isFromStdIn(name) ? copyStream(System.in, System.out) : copyFile(name, System.out);
    }

    private boolean isFromStdIn(final String name) {
        return "-".equals(name);
    }

    boolean copyFile(final String filename, final OutputStream to) throws IOException {
        try (FileInputStream input = new FileInputStream(filename);
            BufferedInputStream bufferedIn = new BufferedInputStream(input); 
        ) {
            return copyStream(bufferedIn, to);
        } catch (FileNotFoundException e) {
            return false;
        }
    }

    boolean copyStream(final InputStream from, final OutputStream to) throws IOException {
        int nextByte;
        while((nextByte = from.read()) != -1) {
            to.write(nextByte);
        }
        to.flush();
        return true;
    }

}
