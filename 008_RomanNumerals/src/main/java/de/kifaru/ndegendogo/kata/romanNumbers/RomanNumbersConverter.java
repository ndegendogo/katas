package de.kifaru.ndegendogo.kata.romanNumbers;

import java.util.function.Function;

public class RomanNumbersConverter implements Function<String, Integer> {

    private int offset;
    private int result;
    private String romanNumber;

    public enum RomanDigit {
        DIGIT_M("M", 1000), DIGIT_CM("CM", 900),
        DIGIT_D("D", 500), DIGIT_CD("CD", 400), DIGIT_C("C", 100), DIGIT_XC("XC", 90),
        DIGIT_L("L", 50), DIGIT_XL("XL", 40), DIGIT_X("X", 10), DIGIT_IX("IX", 9),
        DIGIT_V("V", 5), DIGIT_IV("IV", 4), DIGIT_I("I", 1);

        private final String glyphe;
        private final int value;
        private RomanDigit(String glyphe, int value) {
            this.glyphe = glyphe;
            this.value = value;
        }
        int getValue() {
            return value;
        }
        String getGlyphe() {
            return glyphe;
        }
    };

    @Override
    public Integer apply(final String romanNumber) {
        return convertToArabicNumber(romanNumber);
    }

    Integer convertToArabicNumber(final String romanNumber) {
        init(romanNumber);
        for (RomanDigit digit: RomanDigit.values()) {
            consumeAll(digit);
        }
        if (offset == romanNumber.length()) {
            return result;
        } else {
            return 0;
        }
    }

    private void init(final String romanNumber) {
        result = 0;
        offset = 0;
        this.romanNumber = romanNumber;
    }

    private void consumeAll(RomanDigit digit) {
        while (found(digit.getGlyphe())) {
            consume(digit);
        }
    }

    private boolean found(String glyphe) {
        if (romanNumber.startsWith(glyphe, offset)) {
            return true;
        } else {
            return false;
        }
    }

    private void consume(RomanDigit digit) {
        offset += digit.getGlyphe().length();
        result += digit.getValue();
    }
}
