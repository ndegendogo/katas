package de.kifaru.ndegendogo.kata.bowling;

public class BowlingScore {

    public static void main(String... args) {
        System.out.println("Hello World!");
    }

    static int calculateScore(final Integer[] rolls) {
        int score = 0;
        for (final Integer roll : rolls) {
            score += roll;
        }
        return score;
    }
}
