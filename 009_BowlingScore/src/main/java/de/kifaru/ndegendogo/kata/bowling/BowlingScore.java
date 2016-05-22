package de.kifaru.ndegendogo.kata.bowling;

public class BowlingScore {

    public static void main(String... args) {
        System.out.println("Hello World!");
    }

    public static Integer[] calculateScores(final Integer[][] rolls) {
        Integer[] result = constructResultsArray();
        int frame = 0;
        Integer score = calcScoreForFrame(frame, rolls);
        result[frame] = score;
        return result;
    }

    private static Integer calcScoreForFrame(final int frame, final Integer[][] rolls) {
        Integer score = rolls[frame][0];
        return score;
    }

    private static Integer[] constructResultsArray() {
        Integer[] result = new Integer[1];
        return result;
    }
}
