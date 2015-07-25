package de.kifaru.ndegendogo.kata.fakeOs;

public class Echo {

    public static void main(String... args) {
        final String resultString = getResult(args);
        System.out.println(resultString);
    }

    public static String getResult(String... args) {
        StringBuilder builder = new StringBuilder();
        for(String arg: args) {
            if (builder.length() > 0) {
                builder.append(' ');
            }
            builder.append(arg);
        }
        return builder.toString();
    }

}
