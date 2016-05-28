package de.kifaru.ndegendogo.kata.bowling;



public class Frame {
    abstract class Score {
        String symbol;
        public String toString() {
            return symbol;
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

    private Integer score1;
    private Integer score2;

    void setScore1(Integer score1) {
        this.score1 = score1;
    }

    void setScore2(Integer score2) {
        this.score2 = score2;
    }

    static void rollTheBall(final Integer pins) {
        Frame currentFrame = Game.getCurrentFrame();
        if (currentFrame == null || currentFrame.isFinished()) {
            Game.frames.add(new Frame(pins));
        } else {
            currentFrame.setScore2(pins);
        }
    }

    Frame(final Integer pins) {
        setScore1(pins);
    }

    public String toString() {
        if (isFinished()) {
            return "[" + score1.toString() + "|" + score2.toString() + "]";
        } else {
            return "[" + score1.toString() + "]";
        }

    }

    boolean isFinished() {
        return score2 != null;
    }
}
