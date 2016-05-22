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
                constructTestcase(new Integer[]{0}, 0),
                constructTestcase(new Integer[]{1}, 1),
                constructTestcase(new Integer[]{1, 2}, 3),
                constructTestcase(new Integer[]{}, 0),
                constructTestcase(new Integer[]{10, 2, 5}, 24),
                constructTestcase(new Integer[]{10, 2, }, 14),
                constructTestcase(new Integer[]{2, 7, 10, }, 19),
        });
    }

    private Integer[] rolls;
    private Integer expectedScore;
    private String message;

    public BowlingScoreTest(final Integer[] rolls, final Integer expectedScore, final String message) {
        this.rolls = rolls;
        this.expectedScore = expectedScore;
        this.message = message;
    }

    @Test
    public void testCalculateScore() {
        final Integer actualScore = BowlingScore.calculateScore(rolls);
        assertEquals(expectedScore, actualScore);
    }

    private static Object[] constructTestcase(final Integer[] rolls, final Integer expectedScore) {
        final String message = "rolls = " + Arrays.toString(rolls) + ", expected score = " + expectedScore;
        Object[] testcase1 = new Object[]{rolls, expectedScore, message};
        return testcase1;
    }
}
