package de.kifaru.ndegendogo.kata.fakeOs;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Cat {

    private final OutputStream stdout;

    public Cat(final OutputStream stdout) {
        this.stdout = stdout;
    }
    
    public static void main(final String... args) throws FileNotFoundException, IOException {
        final Cat cat = new Cat(System.out);
        cat.printFile(args[0], System.out);

//        System.out.print("SingleLine");
//        System.out.print("SingleLine\r\r");  // catSingleLineWithMacEnding
//        System.out.print("SingleLine\r\n\r\n");  // catSingleLineWithWindowsEnding
//        System.out.print("SingleLine\n"); // catSingleLineWithoutEnding
//      System.out.print("SingleLine\n\n");  // catSingleLineWithUnixEnding
    }

    void printFile(final String filename, final OutputStream stdout) throws IOException {
        try (FileInputStream input = new FileInputStream(filename);
            BufferedInputStream bufferedIn = new BufferedInputStream(input); 
        ) {
            copyStream(bufferedIn, stdout);
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
