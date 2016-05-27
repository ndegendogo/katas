package de.kifaru.ndegendogo.kata.bowling;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)
public class FrameTest {
    @Parameters
    public static List<Object[]>data() {
        List<Object[]> result = new ArrayList<Object[]>();
        result.add(constructTestcase(new Integer[]{}, "[]", "testFramesNoRoll"));
        result.add(constructTestcase(new Integer[]{1}, "[[1]]", "testFramesFirstRoll"));
        result.add(constructTestcase(new Integer[]{1, 2}, "[[1|2]]", "testFramesTwoRolls"));
        result.add(constructTestcase(new Integer[]{1, 2, 3}, "[[1|2], [3]]", "testFramesThreeRolls"));
        return result;
    }

    private Integer[] rolls;
    private String expectedFrames;
    private String name;

    public FrameTest(final Integer[] rolls, final String expectedFrames, final String name) {
        this.rolls = rolls;
        this.expectedFrames = expectedFrames;
        this.name = name;
    }

    @Test
    public void testFrames() {
        Frame.initFrames();
        for (Integer roll : rolls) {
            Frame.rollTheBall(roll);
        }
        List<Frame> frames = Frame.getFrames();
        assertEquals(expectedFrames, frames.toString());
    }

    static Object[] constructTestcase(final Integer[] rolls, final String expectedFrames, final String name) {
            return new Object[]{rolls, expectedFrames, name};
    }
}
