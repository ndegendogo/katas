package de.kifaru.ndegendogo.kata.bowling;

import java.util.ArrayList;
import java.util.List;


public class Frame {
    private static List<Frame> frames;
    private Integer roll1;

    static void initFrames() {
        frames = new ArrayList<Frame>();
    }

    static List<Frame> getFrames() {
        return frames;
    }

    static void rollTheBall(Integer pins) {
        frames.add(new Frame(pins));
    }

    private Frame(Integer pins) {
        roll1 = pins;
    }

    public String toString() {
        return "[" + roll1.toString() + "]";
    }
}
