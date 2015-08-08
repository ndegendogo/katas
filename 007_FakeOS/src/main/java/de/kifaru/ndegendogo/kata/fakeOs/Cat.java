package de.kifaru.ndegendogo.kata.fakeOs;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

public class Cat {

    private final OutputStream stdout;

    public Cat(final OutputStream stdout) {
        this.stdout = stdout;
    }
    
    public static void main(final String... args) throws FileNotFoundException, IOException {
        final Cat cat = new Cat(System.out);
        cat.printFile(args[0]);

//        System.out.print("SingleLine");
//        System.out.print("SingleLine\r\r");  // catSingleLineWithMacEnding
//        System.out.print("SingleLine\r\n\r\n");  // catSingleLineWithWindowsEnding
//        System.out.print("SingleLine\n"); // catSingleLineWithoutEnding
//      System.out.print("SingleLine\n\n");  // catSingleLineWithUnixEnding
    }

    void printFile(final String filename) throws IOException {
        try (FileInputStream input = new FileInputStream(filename);
            BufferedInputStream bufferedIn = new BufferedInputStream(input); 
        ) {
            copyStream(bufferedIn);
        }
    }

    private void copyStream(final BufferedInputStream bufferedIn) throws IOException {
        do {
            int nextByte = bufferedIn.read();
            if (nextByte == -1) {
                break;
            }
            stdout.write(nextByte);
        } while (true);
        stdout.flush();
    }

}
