package de.kifaru.ndegendogo.kata.fakeOs;

public class Echo {

    public static void main(final String... args) {
        if(args[0].length() > 0) {
            System.out.println(joinStrings(args));
        }
    }

    static String joinStrings(final String... strings) {
        return String.join(" ", strings);
    }

}
