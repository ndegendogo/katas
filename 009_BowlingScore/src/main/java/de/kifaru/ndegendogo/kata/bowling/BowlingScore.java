package de.kifaru.ndegendogo.kata.bowling;

public class BowlingScore {

    public static void main(String... args) {
        System.out.println("Hello World!");
    }

    public static Integer[] calculateScores(final Integer[][] rolls) {
        Integer[] result = constructResultsArray(rolls);
        Integer score = 0;
        for (int frameNumber = 0; frameNumber < rolls.length; frameNumber ++) {
            final Integer[] frame = rolls[frameNumber];
            score += calcScoreForFrame(frame);
            result[frameNumber] = score;
        }
        return result;
    }

    private static Integer[] constructResultsArray(final Integer[][] rolls) {
        Integer[] result = new Integer[rolls.length];
        return result;
    }

    private static Integer calcScoreForFrame(final Integer[] frame) {
        Integer score = 0;
        for (Integer pins: frame) {
            score += pins;
        }
        return score;
    }
}
