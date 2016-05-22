package de.kifaru.ndegendogo.kata.bowling;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class BowlingScoreTest {
    @Parameters(name="testcase {index}: {2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                constructTestcase(new Integer[][]{}, new Integer[]{}),
                constructTestcase(new Integer[][]{{0}}, new Integer[]{0}),
                constructTestcase(new Integer[][]{{1}}, new Integer[]{1}),
                constructTestcase(new Integer[][]{{1, 2}}, new Integer[]{3}),
                constructTestcase(new Integer[][]{{1, 2}, {3}}, new Integer[]{3, 6}),
                constructTestcase(new Integer[][]{{1, 2}, {3, 4}}, new Integer[]{3, 10}),
        });
    }

    private Integer[][] game;
    private Integer[] expectedScores;
    private String message;

    public BowlingScoreTest(final Integer[][] game, final Integer[] expectedScores, final String message) {
        this.game = game;
        this.expectedScores = expectedScores;
        this.message = message;
    }

    @Test
    public void testCalculateScores() {
        final Integer[] actualScores = BowlingScore.calculateScores(game);
        assertArrayEquals(expectedScores, actualScores);
    }

    private static Object[] constructTestcase(final Integer[][] game, final Integer[] expectedScores) {
        final String message = "game = " + toString(game) + ", expected scores = " + Arrays.toString(expectedScores);
        Object[] testcase1 = new Object[]{game, expectedScores, message};
        return testcase1;
    }

    private static String toString(final Integer[][] game) {
        StringBuilder result = new StringBuilder();
        result.append("[");
        for (Integer[] frame: game) {
            result.append(Arrays.toString(frame));
        }
        result.append("]");
        return result.toString();
    }
}
