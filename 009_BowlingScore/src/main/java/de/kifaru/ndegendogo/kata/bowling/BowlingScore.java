package de.kifaru.ndegendogo.kata.bowling;

import java.util.ArrayList;
import java.util.Arrays;
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

    private static boolean isStrike(final Integer[] rolls, final int index) {
        return rolls[index] == 10;
    }

    private static int calculateBonusForStrike(final Integer[] rolls, int index) {
        final List<Integer> slice = makeSlice(rolls, index + 1, 2);
        return addElements(slice);
    }

    private static List<Integer> makeSlice(final Integer[] array, int baseIndex, int sliceLength) {
        final List<Integer> slice = new ArrayList<Integer>();
        for (int index = baseIndex; index < baseIndex + sliceLength; index ++) {
            if (isInRange(index, 0, array.length)) {
                slice.add(array[index]);
            }
        }
        return slice;
    }

    private static boolean isInRange(final int index, final int minIndex, final int maxIndex) {
        return index >= minIndex && index < maxIndex;
    }

    private static int addElements(final List<Integer> slice) {
        int bonus = 0;
        for (Integer element: slice) {
            bonus += element;
        }
        return bonus;
    }

    static List<List<Integer>> splitToFrames(final Integer[] rolls) {
        ArrayList<List<Integer>> frames = new ArrayList<List<Integer>>();
        int offset = 0;
        while (offset < rolls.length) {
            int sliceLength = 2;
            List<Integer> slice = makeFrame(rolls, offset, sliceLength);
            if (slice.size() > 0) {
                frames.add(slice);
            }
            offset += sliceLength;
        }
        return (frames);
    }

    private static List<Integer> makeFrame(final Integer[] rolls, int baseIndex, int sliceLength) {
        final List<Integer> slice = new ArrayList<Integer>();
        for (int index = baseIndex; index < baseIndex + sliceLength; index ++) {
            if (isInRange(index, 0, rolls.length)) {
                slice.add(rolls[index]);
            }
        }
        return slice;
    }
}
