package de.kifaru.ndegendogo.kata.bowling;

public class BowlingScore {

    public static void main(String... args) {
        System.out.println("Hello World!");
    }

    public static Integer[] calculateScores(final Integer[][] game) {
        final int frameCount = game.length;
        final Integer[] totalScores = new Integer[frameCount];
        int totalScore = 0;
        for (int frameIndex = 0; frameIndex < frameCount; frameIndex ++) {
            final Integer[] frame = game[frameIndex];
            final int score = baseScoreForFrame(frame);
            totalScore += score;
            totalScores[frameIndex] = totalScore;
        }
        return totalScores;
    }

    private static int baseScoreForFrame(final Integer[] frame) {
        int score = 0;
        for (int pins: frame) {
            score += pins;
        }
        return score;
    }
}
