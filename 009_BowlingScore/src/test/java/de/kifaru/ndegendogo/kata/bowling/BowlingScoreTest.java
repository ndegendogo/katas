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
    @Parameters(name="{index}: {2}")
    public static Collection<Object[]> data() {
        final Integer[][] input1 = new Integer[][]{{0}};
        final Integer[] output1 = new Integer[]{0};
        Object[] testcase1 = constructTestcase(input1, output1);
        final Integer[][] input2 = new Integer[][]{{1}};
        final Integer[] output2 = new Integer[]{1};
        Object[] testcase2 = constructTestcase(input2, output2);
        return Arrays.asList(new Object[][]{
                testcase1,
                testcase2,
//                {new Integer[][]{{1, 2}}, new Integer[]{3}},
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
        final String message = "rolls = " + Arrays.toString(rolls) + ": scores = " + Arrays.toString(expectedScores);
        Object[] testcase1 = new Object[]{rolls, expectedScores, message};
        return testcase1;
    }
}
