package de.kifaru.ndegendogo.kata.romanNumbers;

import java.util.function.Function;

public class RomanNumbersConverter implements Function<String, Integer> {

    private int offset;
    private int result;
    private String romanNumber;

    public enum RomanDigit {
        DIGIT_M('M', 1000),
        DIGIT_D('D', 500), DIGIT_C('C', 100),
        DIGIT_L('L', 50), DIGIT_X('X', 10),
        DIGIT_V('V', 5), DIGIT_I('I', 1);

        private final char glyphe;
        private final int value;
        private RomanDigit(char glyphe, int value) {
            this.glyphe = glyphe;
            this.value = value;
        }
        int getValue() {
            return value;
        }
        char getGlyphe() {
            return glyphe;
        }
    };

    @Override
    public Integer apply(final String romanNumber) {
        return convertToArabicNumber(romanNumber);
    }

    Integer convertToArabicNumber(final String romanNumber) {
        result = 0;
        offset = 0;
        this.romanNumber = romanNumber;
        for (RomanDigit romanDigit: RomanDigit.values()) {
            consumeAll(romanDigit);
        }
        return result;
    }

    private void consumeAll(RomanDigit romanDigit) {
        while (found(romanDigit.getGlyphe())) {
            consume(romanDigit);
        }
    }

    private boolean found(char glyphe) {
        if (offset >= romanNumber.length()) {
            return false;
        }
        if (romanNumber.charAt(offset) == glyphe) {
            return true;
        } else {
            return false;
        }
    }

    private void consume(RomanDigit digit) {
        offset += 1;
        result += digit.getValue();
    }
}
