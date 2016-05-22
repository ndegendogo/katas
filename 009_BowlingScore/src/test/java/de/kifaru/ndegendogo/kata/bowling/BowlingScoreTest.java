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
        return Arrays.asList(new Object[][]{
                {new Integer[][]{{0}}, new Integer[]{0}},
                {new Integer[][]{{1}}, new Integer[]{1}},
                {new Integer[][]{{1, 2}}, new Integer[]{3}},
        });
    }

    private Integer[][] rolls;
    private Integer[] expectedScores;
    private String message;

    public BowlingScoreTest(final Integer[][] rolls, final Integer[] expectedScores) {
        this.rolls = rolls;
        this.expectedScores = expectedScores;
        this.message = "rolls = " + Arrays.toString(rolls) + ": expected score = " + Arrays.toString(expectedScores);
    }

    @Test
    public void testCalculateScores() {
        final Integer[] actualScores = BowlingScore.calculateScores(rolls);
        assertArrayEquals(expectedScores, actualScores);
    }
}
