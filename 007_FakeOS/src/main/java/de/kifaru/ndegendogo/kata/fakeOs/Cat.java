package de.kifaru.ndegendogo.kata.fakeOs;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Cat {

    public static void main(final String... args) throws FileNotFoundException, IOException {
        String[] filenames = getFilenames(args);
        String firstFileName = filenames[0];
        if (isFromConsole(firstFileName)) {
            copyStream(System.in, System.out);
        } else {
            printFile(firstFileName, System.out);
        }
    }

    private static boolean isFromConsole(String fileName) {
        return "-".equals(fileName);
    }

    private static String[] getFilenames(final String... args) {
        String[] filenames;
        if (args.length == 0) {
            filenames = new String[] {"-"};
        } else {
            filenames = args;
        }
        return filenames;
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
