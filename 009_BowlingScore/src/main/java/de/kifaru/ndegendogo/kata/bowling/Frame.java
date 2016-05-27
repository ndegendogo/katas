package de.kifaru.ndegendogo.kata.bowling;

import java.util.ArrayList;
import java.util.List;


public class Frame {
    private static List<Frame> frames;

    static List<Frame> initFrames() {
        frames = new ArrayList<Frame>();
        return frames;
    }
    static List<Frame> getFrames() {
        return frames;
    }
}
