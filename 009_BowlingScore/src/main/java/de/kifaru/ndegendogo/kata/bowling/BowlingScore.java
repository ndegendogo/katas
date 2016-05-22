package de.kifaru.ndegendogo.kata.bowling;

public class BowlingScore {

    public static void main(String... args) {
        System.out.println("Hello World!");
    }

    static int calculateScore(final Integer[] rolls) {
        int score = 0;
        for (int index = 0; index < rolls.length; index ++) {
            score += rolls[index];
            final int bonus = isStrike(rolls, index) ? calculateBonusForStrike(rolls, index) : 0;
            score += bonus;
        }
        return score;
    }

    private static int calculateBonusForStrike(final Integer[] rolls, int index) {
        int bonus = 0;
        index ++;
        if (index < rolls.length) { 
            bonus += rolls[index];
        }
        index ++;
        if (index < rolls.length) { 
            bonus += rolls[index];
        }
        return bonus;
    }

    private static boolean isStrike(final Integer[] rolls, int index) {
        return rolls[index] == 10;
    }
}
