package de.kifaru.ndegendogo.kata.bowling;

import java.util.ArrayList;
import java.util.List;


public class Frame {
    private static List<Frame> frames;

    static void initFrames() {
        frames = new ArrayList<Frame>();
    }

    static List<Frame> getFrames() {
        return frames;
    }

    static void rollTheBall(Integer pins) {
    }
}
