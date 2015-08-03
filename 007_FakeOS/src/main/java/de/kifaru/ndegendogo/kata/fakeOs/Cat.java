package de.kifaru.ndegendogo.kata.fakeOs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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

    private void printFile(final String filename) throws IOException {
        final Path path = Paths.get(filename);
        Files.copy(path, stdout);
    }

    static String getContentOfFile(String filename) throws FileNotFoundException, IOException {
        StringBuilder result = new StringBuilder();
        try (FileInputStream file = new FileInputStream(filename);
             InputStreamReader in = new InputStreamReader(file);) {
            int numberOfBytes;
            do {
                numberOfBytes = in.read();
                if (numberOfBytes > 0) {
                    result.append((char)numberOfBytes);
                }
            } while (numberOfBytes > 0);
        }
        return result.toString();
    }

}
