package de.kifaru.ndegendogo.kata.fakeOs;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Cat {

    public static void main(final String... args) throws FileNotFoundException, IOException {
        if ((args.length == 0) || ("-".equals(args[0]))) {
            copyStream(System.in, System.out);
        } else {
            printFile(args[0], System.out);
        }
    }

    static void printFile(final String filename, final OutputStream to) throws IOException {
        try (FileInputStream input = new FileInputStream(filename);
            BufferedInputStream bufferedIn = new BufferedInputStream(input); 
        ) {
            copyStream(bufferedIn, to);
        }
    }

    private static void copyStream(final InputStream from, final OutputStream to) throws IOException {
        do {
            int nextByte = from.read();
            if (nextByte == -1) {
                break;
            }
            to.write(nextByte);
        } while (true);
        to.flush();
    }

}
