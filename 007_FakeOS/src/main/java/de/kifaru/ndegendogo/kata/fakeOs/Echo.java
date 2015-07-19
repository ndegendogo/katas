package de.kifaru.ndegendogo.kata.fakeOs;

public class Echo {

    public static void main(String... args) {
        final String resultString = getResult(args[0]);
        System.out.println(resultString);
    }

    public static String getResult(String... params) {
        StringBuilder builder = new StringBuilder();
        {
            final String string = params[0];
            appendString(builder, string);
        }
        if (params.length > 1) {
            final String string = params[1];
            appendString(builder, string);
        }
        return builder.toString().trim();
    }

    public static void appendString(StringBuilder builder, final String string) {
        builder.append(string);
        builder.append(' ');
    }

}
