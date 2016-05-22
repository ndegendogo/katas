package de.kifaru.ndegendogo.kata.bowling;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class SplitFramesTest {
    @Parameters(name = "testcase {index}:")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] {
        });
    }

    private Integer[] rolls;
    private Integer[][] expectedFrames;
    private String message;

    public SplitFramesTest(final Integer[] rolls, final Integer[][] expectedFrames, final String message) {
        this.rolls = rolls;
        this.expectedFrames = expectedFrames;
        this.message = message;
    }

    @Test
    public void testSplitToFrames() {
        Integer[][] actualFrames = splitToFrames(rolls);
        assertArrayEquals(expectedFrames, actualFrames);
    }

    Integer[][] splitToFrames(Integer[] rolls) {
        return null;
    }
}
