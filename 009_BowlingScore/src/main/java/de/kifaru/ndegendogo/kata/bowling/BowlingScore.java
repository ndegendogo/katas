package de.kifaru.ndegendogo.kata.bowling;

public class BowlingScore {

    public static void main(String... args) {
        System.out.println("Hello World!");
    }

    public static Integer[] calculateScores(final Integer[][] rolls) {
        Integer[] result = new Integer[1];
        Integer score = rolls[0][0];
        result[0] = score;
        return result;
    }
}
