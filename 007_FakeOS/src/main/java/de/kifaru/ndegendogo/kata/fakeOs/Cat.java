package de.kifaru.ndegendogo.kata.fakeOs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Cat {

    public static void main(String... args) throws FileNotFoundException, IOException {
        System.out.print(getContentOfFile(args[0]));
//        System.out.print("SingleLine");
//        System.out.print("SingleLine\r\r");  // catSingleLineWithMacEnding
//        System.out.print("SingleLine\r\n\r\n");  // catSingleLineWithWindowsEnding
//        System.out.print("SingleLine\n"); // catSingleLineWithoutEnding
//      System.out.print("SingleLine\n\n");  // catSingleLineWithUnixEnding
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
