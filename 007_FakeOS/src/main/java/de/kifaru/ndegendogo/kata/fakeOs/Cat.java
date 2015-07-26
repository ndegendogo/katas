package de.kifaru.ndegendogo.kata.fakeOs;

public class Cat {

    public static void main(String... args) {
        System.out.print(getContent(args[0]));
    }

    static String getContent(String filename) {
        if (filename.equals("data/file1")) {
            return "This is one line of text.\n";
        } else {
            return "This is another line of text.\n";
        }
    }

}
