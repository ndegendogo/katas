package de.kifaru.ndegendogo.kata.fakeOs;

public class Echo {

    public static void main(String... args) {
        final String resultString = getResult(args[0]);
        System.out.println(resultString);
    }

    public static String getResult(String... params) {
        StringBuilder builder = new StringBuilder();
        if (params.length == 1) {
            builder.append(params[0]);
        } else {
            builder.append(params[0]);
            builder.append(' ');
            builder.append(params[1]);
        }
        return builder.toString();
    }

}
