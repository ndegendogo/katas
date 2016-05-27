package de.kifaru.ndegendogo.kata.bowling;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;


public class FrameTest {

    @Test
    public void testFramesNoRoll() {
        Integer[] rolls = {};
        Frame.initFrames();
        for (Integer roll : rolls) {
            Frame.rollTheBall(roll);
        }
        List<Frame> frames = Frame.getFrames();
        assertEquals("[]", frames.toString());
    }

    @Test
    public void testFramesFirstRoll() {
        Integer[] rolls = {1};
        Frame.initFrames();
        for (Integer roll : rolls) {
            Frame.rollTheBall(roll);
        }
        List<Frame> frames = Frame.getFrames();
        assertEquals("[[1]]", frames.toString());
    }

    @Test
    public void testFramesTwoRolls() {
        Integer[] rolls = {1, 2};
        Frame.initFrames();
        for (Integer roll : rolls) {
            Frame.rollTheBall(roll);
        }
        List<Frame> frames = Frame.getFrames();
        assertEquals("[[1|2]]", frames.toString());
    }

    @Test
    public void testFramesThreeRolls() {
        Integer[] rolls = {1, 2, 3};
        Frame.initFrames();
        for (Integer roll : rolls) {
            Frame.rollTheBall(roll);
        }
        List<Frame> frames = Frame.getFrames();
        assertEquals("[[1|2], [3]]", frames.toString());
    }
}
