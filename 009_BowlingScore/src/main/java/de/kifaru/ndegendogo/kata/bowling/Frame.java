package de.kifaru.ndegendogo.kata.bowling;



public class Frame {
    enum Score {
        EMPTY(' '),
        MISS('-'),
        ONE('1'),
        TWO('2'),
        THREE('3'),
        FOUR('4'),
        FIVE('5'),
        SIX('6'),
        SEVEN('7'),
        EIGHT('8'),
        NINE('9'),
        STRIKE('X'),
        SPARE('/'),
        FOUL('F');

        private char symbol;

        private Score(char symbol) {
            this.symbol = symbol;
        }
    };

    private Integer score1;
    private Integer score2;

    static void rollTheBall(final Integer pins) {
        if (Game.frames.isEmpty()) {
            Game.frames.add(new Frame(pins));
        } else {
            Frame currentFrame = Game.getCurrentFrame();
            if (currentFrame.score2 == null) {
                currentFrame.score2 = pins;
            } else {
                Game.frames.add(new Frame(pins));
            }
        }
    }

    Frame(final Integer pins) {
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
