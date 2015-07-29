package de.kifaru.ndegendogo.kata.fakeOs;

public class Cat {

    public static void main(String... args) {
//        System.out.print(getContentOfFile(args[0]));
//        System.out.print("SingleLine"); // catSingleLineWithUnixEnding, catSingleLineWithoutEnding
//        System.out.print("SingleLine\r\r");  // catSingleLineWithMacEnding
        System.out.print("SingleLine\r\n\r");  // catSingleLineWithWindowsEnding
//        System.out.print("SingleLine\n"); // catSingleLineWithUnixEnding, catSingleLineWithoutEnding
//      System.out.print("SingleLine\n\n");  // catSingleLineWithUnixEnding, catSingleLineWithoutEnding
    }

    static String getContentOfFile(String filename) {
        if (filename.equals("data/file1")) {
            return "This is one line of text.\n";
        } else {
            return "This is another line of text.\n";
        }
    }

}
