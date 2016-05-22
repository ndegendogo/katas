package de.kifaru.ndegendogo.kata.bowling;

public class BowlingScore {

    public static void main(String... args) {
        System.out.println("Hello World!");
    }

    public static Integer[] calculateScores(final Integer[][] rolls) {
        Integer[] result = constructResultsArray();
        int frame = 0;
        Integer score = rolls[frame][0];
        result[frame] = score;
        return result;
    }

    private static Integer[] constructResultsArray() {
        Integer[] result = new Integer[1];
        return result;
    }
}
