package de.kifaru.ndegendogo.kata.fakeOs;

public class Echo {

    public static void main(String... args) {
        final String resultString = getResult("");
        System.out.println(resultString);
    }

    public static String getResult(String dummy) {
        final String resultString = dummy;
        return resultString;
    }

}
