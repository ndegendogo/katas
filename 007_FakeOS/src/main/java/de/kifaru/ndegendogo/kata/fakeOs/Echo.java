package de.kifaru.ndegendogo.kata.fakeOs;

public class Echo {

    public static void main(String... args) {
        final String resultString = getResult(args[0]);
        System.out.println(resultString);
    }

    public static String getResult(String... params) {
        String resultString;
        if (params.length == 1) {
            resultString = params[0];
        } else {
            resultString = params[0] + ' ' + params[1];
        }
        return resultString;
    }

}
