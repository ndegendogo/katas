package de.kifaru.ndegendogo.kata.bowling;

import static org.junit.Assert.*;

import org.junit.Test;

public class BowlingScoreTest {

    Integer[] calculateScores(Integer[][] rolls) {
        return new Integer[]{0};
    }

    @Test
    public void testCalculateScores() {
        Integer[][] rolls = {{0}};
        Integer[] expectedScores = {0};
        Integer[] actualScores = calculateScores(rolls);
        assertArrayEquals(expectedScores, actualScores);
    }
}
