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
        List<Object[]> result = new ArrayList<Object[]>();
        result.add(constructTestcase(new Integer[] {0},
                Arrays.asList(new Integer[] {0})));
        result.add(constructTestcase(new Integer[] {1, 2},
                Arrays.asList(new Integer[] {1, 2})));
        result.add(constructTestcase(new Integer[] {} ));
        result.add(constructTestcase(new Integer[] {1, 2, 3, 4},
                Arrays.asList(new Integer[] {1, 2}),
                Arrays.asList(new Integer[] {3, 4})));
        return result;
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
        List<List<Integer>> actualFrames = Frame.splitToFrames(rolls);
        assertEquals(expectedFrames, actualFrames);
    }

    @SafeVarargs
    static Object[] constructTestcase(final Integer[] rolls, final List<Integer>... frames) {
        ArrayList<List<Integer>> expectedFrames = new ArrayList<List<Integer>>();
        for (final List<Integer> frame : frames) {
            expectedFrames.add(frame);
        }
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
