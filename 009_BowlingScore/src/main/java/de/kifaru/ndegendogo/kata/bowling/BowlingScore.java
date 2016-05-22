package de.kifaru.ndegendogo.kata.bowling;

public class BowlingScore {

    public static void main(String... args) {
        System.out.println("Hello World!");
    }

    public static Integer[] calculateScores(final Integer[][] game) {
        Integer[] result = constructResultsArray(game);
        int totalScore = 0;
        for (int frameNumber = 0; frameNumber < game.length; frameNumber ++) {
            final Integer[] frame = game[frameNumber];
            final int score = calcScoreForFrame(frame);
            totalScore += score;
            result[frameNumber] = totalScore;
        }
        return result;
    }

    private static Integer[] constructResultsArray(final Integer[][] game) {
        Integer[] result = new Integer[game.length];
        return result;
    }

    private static int calcScoreForFrame(final Integer[] frame) {
        int score = 0;
        for (int pins: frame) {
            score += pins;
        }
        return score;
    }
}
