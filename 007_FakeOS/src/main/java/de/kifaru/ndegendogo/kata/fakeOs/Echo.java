package de.kifaru.ndegendogo.kata.fakeOs;

public class Echo {

    public static void main(final String... args) {
        System.out.println(joinStrings(args));
        System.exit(1);
    }

    static String joinStrings(final String... strings) {
        return String.join(" ", strings);
    }

}
