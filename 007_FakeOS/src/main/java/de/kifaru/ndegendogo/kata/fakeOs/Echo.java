package de.kifaru.ndegendogo.kata.fakeOs;

public class Echo {

    public static void main(final String... args) {
        System.out.println("Hello world!");
        System.out.println(joinStrings(args));
    }

    static String joinStrings(final String... strings) {
        return String.join(" ", strings);
    }

}
