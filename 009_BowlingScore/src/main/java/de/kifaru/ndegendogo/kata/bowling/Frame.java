package de.kifaru.ndegendogo.kata.bowling;

import java.util.ArrayList;
import java.util.List;

public class Frame {

    static List<List<Integer>> splitToFrames(final Integer[] rolls) {
        ArrayList<List<Integer>> frames = new ArrayList<List<Integer>>();
        int offset = 0;
        while (offset < rolls.length) {
            int sliceLength = 2;
            List<Integer> slice = BowlingScore.makeFrame(rolls, offset, sliceLength);
            if (slice.size() > 0) {
                frames.add(slice);
            }
            offset += sliceLength;
        }
        return (frames);
    }
}
