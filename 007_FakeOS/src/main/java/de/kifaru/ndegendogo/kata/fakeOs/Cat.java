package de.kifaru.ndegendogo.kata.fakeOs;

public class Cat {

    public static void main(String... args) {
        System.out.print(getContentOfFile(args[0]));
//        System.out.print("SingleLine");
//        System.out.print("SingleLine\r\r");  // catSingleLineWithMacEnding
//        System.out.print("SingleLine\r\n\r\n");  // catSingleLineWithWindowsEnding
//        System.out.print("SingleLine\n"); // catSingleLineWithoutEnding
//      System.out.print("SingleLine\n\n");  // catSingleLineWithUnixEnding
    }

    static String getContentOfFile(String filename) {
        StringBuilder result = new StringBuilder();
        if (filename.equals("data/file1")) {
            result.append("This is one line of text.\n");
        } else {
            result.append("This is another line of text.\n");
        }
        return result.toString();
    }

}
