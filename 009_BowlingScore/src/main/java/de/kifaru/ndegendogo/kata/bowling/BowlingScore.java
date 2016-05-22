package de.kifaru.ndegendogo.kata.bowling;

public class BowlingScore {

    public static void main(String... args) {
        System.out.println("Hello World!");
    }

    static int calculateScore(final Integer[] rolls) {
        int score = 0;
        for (int index = 0; index < rolls.length; index ++) {
            score += rolls[index];
            if (isStrike(rolls, index)) {
                score += calculateBonusForStrike(rolls, index);
            }
        }
        return score;
    }

    private static int calculateBonusForStrike(final Integer[] rolls, int index) {
        return rolls[index +1] + rolls[index +2];
    }

    private static boolean isStrike(final Integer[] rolls, int index) {
        return rolls[index] == 10;
    }
}
