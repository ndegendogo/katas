package de.kifaru.ndegendogo.kata.bowling;

import java.util.ArrayList;
import java.util.List;


public class Frame {
    private static List<Frame> frames;
    private Integer roll1;
    private Integer roll2;

    static void initFrames() {
        frames = new ArrayList<Frame>();
    }

    static List<Frame> getFrames() {
        return frames;
    }

    static void rollTheBall(Integer pins) {
        if (frames.isEmpty()) {
            frames.add(new Frame(pins));
        } else {
            int lastIndex = frames.size() -1;
            Frame lastFrame = frames.get(lastIndex);
            if (lastFrame.roll2 == null) {
                lastFrame.roll2 = pins;
            } else {
                frames.add(new Frame(pins));
            }
        }
    }

    private Frame(Integer pins) {
        roll1 = pins;
    }

    public String toString() {
        if (roll2 == null) {
            return "[" + roll1.toString() + "]";
        } else {
            return "[" + roll1.toString() + "|" + roll2.toString() + "]";
        }

    }
}
