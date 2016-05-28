package de.kifaru.ndegendogo.kata.bowling;

import java.util.ArrayList;
import java.util.List;

public class Game {

    static List<Frame> frames;

    static void initFrames() {
        frames = new ArrayList<Frame>();
    }

    static List<Frame> getFrames() {
        return frames;
    }

    static Frame getCurrentFrame() {
        return frames.isEmpty() ? null : frames.get(frames.size() -1);
    }

}
