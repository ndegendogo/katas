package de.kifaru.ndegendogo.kata.bowling;

public class BowlingScore {

    public static void main(String... args) {
        System.out.println("Hello World!");
    }

    public static Integer[] calculateScores(final Integer[][] rolls) {
        Integer[] result = constructResultsArray();
        int frameNumber = 0;
        final Integer[] frame = rolls[frameNumber];
        Integer score = calcScoreForFrame(frameNumber, rolls, frame);
        result[frameNumber] = score;
        return result;
    }

    private static Integer calcScoreForFrame(final int frameNumber, final Integer[][] rolls, Integer[] frame) {
        Integer score = 0;
        for (Integer pins: frame) {
            score += pins;
        }
        return score;
    }

    private static Integer[] constructResultsArray() {
        Integer[] result = new Integer[1];
        return result;
    }
}
