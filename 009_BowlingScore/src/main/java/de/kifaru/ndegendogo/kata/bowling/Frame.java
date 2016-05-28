package de.kifaru.ndegendogo.kata.bowling;



public class Frame {
    abstract class Score {
        String symbol;
        public String toString() {
            return symbol;
        }
        boolean isEmpty() {
            return this instanceof EmptyScore;
        }
    };
    class EmptyScore extends Score {
        EmptyScore() {
            symbol = " ";
        }
    };
    class NumberScore extends Score {
        NumberScore(Integer score) {
            symbol = score.toString();
        }
    };

    private Score score1 = new EmptyScore();
    private Score score2 = new EmptyScore();

    void setScore(Integer score) {
        if (score1.isEmpty()) {
            score1 = new NumberScore(score);
        } else {
            score2 = new NumberScore(score);
        }
    }

    static void rollTheBall(final Integer pins) {
        Frame currentFrame = Game.getCurrentFrame();
        if (currentFrame == null || currentFrame.isFinished()) {
            final Frame newFrame = new Frame();
            newFrame.setScore(pins);
            Game.frames.add(newFrame);
        } else {
            currentFrame.setScore(pins);
        }
    }

    public String toString() {
        if (isFinished()) {
            return "[" + score1.toString() + "|" + score2.toString() + "]";
        } else {
            return "[" + score1.toString() + "]";
        }

    }

    boolean isFinished() {
        return !score2.isEmpty();
    }
}
