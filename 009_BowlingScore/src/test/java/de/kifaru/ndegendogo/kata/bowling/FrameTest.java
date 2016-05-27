package de.kifaru.ndegendogo.kata.bowling;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;


public class FrameTest {

    @Test
    public void testFramesNoRoll() {
        Frame.initFrames();
        List<Frame> frames = Frame.getFrames();
        assertEquals("[]", frames.toString());
    }

    @Test
    public void testFramesFirstRoll() {
        Frame.initFrames();
        Frame.rollTheBall(1);
        List<Frame> frames = Frame.getFrames();
        assertEquals("[[1]]", frames.toString());
    }

    @Test
    public void testFramesTwoRolls() {
        Frame.initFrames();
        Frame.rollTheBall(1);
        Frame.rollTheBall(2);
        List<Frame> frames = Frame.getFrames();
        assertEquals("[[1|2]]", frames.toString());
    }

    @Test
    public void testFramesThreeRolls() {
        Frame.initFrames();
        Frame.rollTheBall(1);
        Frame.rollTheBall(2);
        Frame.rollTheBall(3);
        List<Frame> frames = Frame.getFrames();
        assertEquals("[[1|2], [3]]", frames.toString());
    }
}
