package de.kifaru.ndegendogo.kata.bowling;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class SplitFramesTest {
    @Parameters(name = "testcase {index}: {2}")
    public static Iterable<Object[]> data() {
        Integer[] rolls = new Integer[] {0};
        List<Integer> frame1 = Arrays.asList(new Integer[] {0});
        ArrayList<List<Integer>> expectedFrames = new ArrayList<List<Integer>>();
        expectedFrames.add(frame1);
        Object[] testcase1 = constructTestcase(rolls, frame1, expectedFrames);
        return Arrays.asList(new Object[][] {
            testcase1,
        });
    }

    private Integer[] rolls;
    private List<List<Integer>> expectedFrames;
    private String message;

    public SplitFramesTest(final Integer[] rolls, final List<List<Integer>> expectedFrames, final String message) {
        this.rolls = rolls;
        this.expectedFrames = expectedFrames;
        this.message = message;
    }

    @Test
    public void testSplitToFrames() {
        List<List<Integer>> actualFrames = BowlingScore.splitToFrames(rolls);
        assertEquals(expectedFrames, actualFrames);
    }

    static Object[] constructTestcase(Integer[] rolls, List<Integer> frame, List<List<Integer>> expectedFrames) {
        final String message = "rolls = " + Arrays.toString(rolls) + ", expectedFrames = " + printFrames(expectedFrames);
        return new Object[]{rolls, expectedFrames, message};
    }

    private static String printFrames(final List<List<Integer>> frames) {
        final StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (List<Integer> frame : frames) {
            builder.append(Arrays.toString(frame.toArray()));
        }
        builder.append("]");
        return builder.toString();
    }
}
