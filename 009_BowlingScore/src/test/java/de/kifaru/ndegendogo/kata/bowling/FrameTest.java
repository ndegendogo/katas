package de.kifaru.ndegendogo.kata.bowling;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;


public class FrameTest {

    @Test
    public void testFramesNoRoll() {
        List<Frame> frames = Frame.initFrames();
        assertEquals(0, frames.size());
    }
}
