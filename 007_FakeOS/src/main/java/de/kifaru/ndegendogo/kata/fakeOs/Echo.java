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
        return builder.toString().trim();
    }

    public static void appendArg(StringBuilder builder, final String arg) {
        builder.append(arg);
        builder.append(' ');
    }

}
