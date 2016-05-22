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
                constructTestcase(new Integer[][]{{0}}, new Integer[]{0}),
                constructTestcase(new Integer[][]{{1}}, new Integer[]{1}),
                constructTestcase(new Integer[][]{{1, 2}}, new Integer[]{3}),
        });
    }

    private Integer[][] rolls;
    private Integer[] expectedScores;
    private String message;

    public BowlingScoreTest(final Integer[][] rolls, final Integer[] expectedScores, final String message) {
        this.rolls = rolls;
        this.expectedScores = expectedScores;
        this.message = message;
    }

    @Test
    public void testCalculateScores() {
        final Integer[] actualScores = BowlingScore.calculateScores(rolls);
        assertArrayEquals(expectedScores, actualScores);
    }

    private static Object[] constructTestcase(final Integer[][] rolls, final Integer[] expectedScores) {
        final String message = "rolls = " + toString(rolls) + ", expected scores = " + Arrays.toString(expectedScores);
        Object[] testcase1 = new Object[]{rolls, expectedScores, message};
        return testcase1;
    }

    private static String toString(final Integer[][] rolls) {
        StringBuilder result = new StringBuilder();
        result.append("[");
        for (Integer[] frame: rolls) {
            result.append(Arrays.toString(frame));
        }
        result.append("]");
        return result.toString();
    }
}
