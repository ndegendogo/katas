package de.kifaru.ndegendogo.kata.bowling;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;


public class FrameTest {

    @Test
    public void testFramesNoRoll() {
        Integer[] rolls = {};
        String expectedFrames = "[]";
        String name = "testFramesNoRoll";
        Frame.initFrames();
        for (Integer roll : rolls) {
            Frame.rollTheBall(roll);
        }
        List<Frame> frames = Frame.getFrames();
        assertEquals(expectedFrames, frames.toString());
    }

    @Test
    public void testFramesFirstRoll() {
        Integer[] rolls = {1};
        String expectedFrames = "[[1]]";
        String name = "testFramesFirstRoll";
        Frame.initFrames();
        for (Integer roll : rolls) {
            Frame.rollTheBall(roll);
        }
        List<Frame> frames = Frame.getFrames();
        assertEquals(expectedFrames, frames.toString());
    }

    @Test
    public void testFramesTwoRolls() {
        Integer[] rolls = {1, 2};
        String expectedFrames = "[[1|2]]";
        String name = "testFramesTwoRolls";
        Frame.initFrames();
        for (Integer roll : rolls) {
            Frame.rollTheBall(roll);
        }
        List<Frame> frames = Frame.getFrames();
        assertEquals(expectedFrames, frames.toString());
    }

    @Test
    public void testFramesThreeRolls() {
        Integer[] rolls = {1, 2, 3};
        String expectedFrames = "[[1|2], [3]]";
        String name = "testFramesThreeRolls";
        Frame.initFrames();
        for (Integer roll : rolls) {
            Frame.rollTheBall(roll);
        }
        List<Frame> frames = Frame.getFrames();
        assertEquals(expectedFrames, frames.toString());
    }
}
