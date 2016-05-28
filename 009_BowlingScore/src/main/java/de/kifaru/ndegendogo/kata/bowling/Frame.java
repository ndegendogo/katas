package de.kifaru.ndegendogo.kata.bowling;



public class Frame {
    private Integer score1;
    private Integer score2;

    static void rollTheBall(Integer pins) {
        if (Game.frames.isEmpty()) {
            Game.frames.add(new Frame(pins));
        } else {
            int lastIndex = Game.frames.size() -1;
            Frame lastFrame = Game.frames.get(lastIndex);
            if (lastFrame.score2 == null) {
                lastFrame.score2 = pins;
            } else {
                Game.frames.add(new Frame(pins));
            }
        }
    }

    Frame(Integer pins) {
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
