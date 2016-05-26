package de.kifaru.ndegendogo.kata.bowling;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.hamcrest.Matcher;
import org.hamcrest.core.IsEqual;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class SplitFramesTest {
    @Parameters(name = "testcase {index}: {2}")
    public static Iterable<Object[]> data() {
        Integer[] rolls = new Integer[] {0};
        Integer[] frame1 = new Integer[] {0};
        ArrayList<Integer[]> expectedFrames = new ArrayList<Integer[]>();
        expectedFrames.add(frame1);
        Object[] testcase1 = constructTestcase(rolls, expectedFrames);
        return Arrays.asList(new Object[][] {
            testcase1,
        });
    }

    private Integer[] rolls;
    private ArrayList<Integer[]> expectedFrames;
    private String message;

    public SplitFramesTest(final Integer[] rolls, final ArrayList<Integer[]> expectedFrames, final String message) {
        this.rolls = rolls;
        this.expectedFrames = expectedFrames;
        this.message = message;
    }

    @Test
    public void testSplitToFrames() {
        ArrayList<Integer[]> actualFrames = splitToFrames(rolls);
        Matcher<ArrayList<Integer[]>> matcher = new IsEqual<ArrayList<Integer[]>>(expectedFrames);
        assertThat(actualFrames, matcher); //expectedFrames,
    }

    ArrayList<Integer[]> splitToFrames(Integer[] rolls) {
        return null;
/*
        ArrayList<Integer[]> frames = new ArrayList<Integer[]>();
        frames.add(rolls);
        return (Integer[][]) frames.toArray();
*/
    }

    static Object[] constructTestcase(Integer[] rolls, ArrayList<Integer[]> expectedFrames) {
        final String message = "rolls = " + Arrays.toString(rolls) + ", expectedFrames = " + printFrames(expectedFrames);
        return new Object[]{rolls, expectedFrames, message};
    }

    private static String printFrames(final ArrayList<Integer[]> frames) {
        final StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (Integer[] frame : frames) {
            builder.append(Arrays.toString(frame));
        }
        builder.append("]");
        return builder.toString();
    }
}
