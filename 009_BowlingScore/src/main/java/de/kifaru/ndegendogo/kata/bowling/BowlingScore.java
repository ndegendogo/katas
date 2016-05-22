package de.kifaru.ndegendogo.kata.bowling;

import java.util.ArrayList;
import java.util.List;

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
        int sliceLength = 2;
        int baseIndex = index + 1;
        List<Integer> slice = makeSlice(rolls, baseIndex, sliceLength);

        int bonus = 0;
        for (Integer element: slice) {
            bonus += element;
        }
        return bonus;
    }

    private static List<Integer> makeSlice(final Integer[] rolls, int baseIndex, int sliceLength) {
        int minIndex = 0;
        int maxIndex = rolls.length;
        List<Integer> slice = new ArrayList<Integer>();
        for (int index = baseIndex; index < baseIndex + sliceLength; index ++) {
            if (isInRange(index, minIndex, maxIndex)) {
                slice.add(rolls[index]);
            }
        }
        return slice;
    }

    private static boolean isInRange(int index, int minIndex, int maxIndex) {
        return index >= minIndex && index < maxIndex;
    }

    private static boolean isStrike(final Integer[] rolls, int index) {
        return rolls[index] == 10;
    }
}
