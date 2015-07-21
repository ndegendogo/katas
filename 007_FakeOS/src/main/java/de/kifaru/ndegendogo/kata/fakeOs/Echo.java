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
        final String string = builder.toString();
        String result;
        if (args.length == 0) {
            result = string;
        } else {
            result = string.substring(0, string.length() - 1);
        }
        return result;
    }

    public static void appendArg(StringBuilder builder, final String arg) {
        builder.append(arg);
        builder.append(' ');
    }

}
