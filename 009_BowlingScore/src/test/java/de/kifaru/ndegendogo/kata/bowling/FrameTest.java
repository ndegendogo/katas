package de.kifaru.ndegendogo.kata.bowling;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;


public class FrameTest {

    @Test
    public void testFramesNoRoll() {
        Frame.initFrames();
        List<Frame> frames = Frame.getFrames();
        assertEquals(0, frames.size());
    }

    @Test
    public void testFramesFirstRoll() {
        Frame.initFrames();
        Frame.rollTheBall(1);
        List<Frame> frames = Frame.getFrames();
        assertEquals(1, frames.size());
        assertEquals("[1]", frames.get(0).toString());
    }
}
