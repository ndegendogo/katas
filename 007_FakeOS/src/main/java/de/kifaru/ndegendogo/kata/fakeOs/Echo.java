package de.kifaru.ndegendogo.kata.fakeOs;

public class Echo {

    public static void main(String... args) {
        final String resultString = getResult(args[0]);
        System.out.println(resultString);
    }

    public static String getResult(String... params) {
        StringBuilder builder = new StringBuilder();
        builder.append(params[0]);
        builder.append(' ');
        if (params.length > 1) {
            builder.append(params[1]);
            builder.append(' ');
        }
        return builder.toString().trim();
    }

}
