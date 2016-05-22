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
        Integer[] rolls = new Integer[] {0};
        Integer[] frame1 = new Integer[] {0};
        Integer[][] expectedFrames = new Integer[][]{frame1};
        Object[] testcase1 = constructTestcase(rolls, expectedFrames);
        return Arrays.asList(new Object[][] {
            testcase1,
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

    static Object[] constructTestcase(Integer[] rolls, Integer[][] expectedFrames) {
        return new Object[]{rolls, expectedFrames, null};
    }
}
