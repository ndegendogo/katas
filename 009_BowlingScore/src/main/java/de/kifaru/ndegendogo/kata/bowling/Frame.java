package de.kifaru.ndegendogo.kata.bowling;

import java.util.ArrayList;
import java.util.List;

public class Frame {

    static List<List<Integer>> splitToFrames(final Integer[] rolls) {
        ArrayList<List<Integer>> frames = new ArrayList<List<Integer>>();
        int offset = 0;
        while (offset < rolls.length) {
            int sliceLength = 2;
            List<Integer> slice = Frame.makeFrame(rolls, offset, sliceLength);
            if (slice.size() > 0) {
                frames.add(slice);
            }
            offset += sliceLength;
        }
        return (frames);
    }

    static List<Integer> makeFrame(final Integer[] rolls, int baseIndex, int sliceLength) {
        final List<Integer> slice = new ArrayList<Integer>();
        for (int index = baseIndex; index < baseIndex + sliceLength; index ++) {
            if (BowlingScore.isInRange(index, 0, rolls.length)) {
                slice.add(rolls[index]);
            }
        }
        return slice;
    }
}
