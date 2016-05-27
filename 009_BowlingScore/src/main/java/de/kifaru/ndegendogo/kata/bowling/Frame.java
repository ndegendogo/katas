package de.kifaru.ndegendogo.kata.bowling;

import java.util.ArrayList;
import java.util.List;


public class Frame {
    private static List<Frame> frames;
    private Integer score1;
    private Integer score2;

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
            if (lastFrame.score2 == null) {
                lastFrame.score2 = pins;
            } else {
                frames.add(new Frame(pins));
            }
        }
    }

    private Frame(Integer pins) {
        score1 = pins;
    }

    public String toString() {
        if (score2 == null) {
            return "[" + score1.toString() + "]";
        } else {
            return "[" + score1.toString() + "|" + score2.toString() + "]";
        }

    }
}
