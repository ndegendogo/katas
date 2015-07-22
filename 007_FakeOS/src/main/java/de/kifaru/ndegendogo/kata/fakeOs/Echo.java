package de.kifaru.ndegendogo.kata.fakeOs;

public class Echo {

    public static void main(String... args) {
        final String resultString = getResult(args);
        System.out.println(resultString);
    }

    public static String getResult(String... args) {
        StringBuilder builder = new StringBuilder();
        for(String arg: args) {
            appendArg(builder, arg);
        }
        return builder.toString();
    }

    public static void appendArg(StringBuilder builder, final String arg) {
        if (builder.length() > 0) {
            builder.append(' ');
        }
        builder.append(arg);
    }

}
