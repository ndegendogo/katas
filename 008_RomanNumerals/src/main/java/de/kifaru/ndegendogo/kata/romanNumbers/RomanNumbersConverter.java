package de.kifaru.ndegendogo.kata.romanNumbers;

import java.util.function.Function;

public class RomanNumbersConverter implements Function<String, Integer> {

    private int offset;
    private int result;
    private String romanNumber;

    public enum RomanDigit {
        DIGIT_X('X', 10), DIGIT_V('V', 5), DIGIT_I('I', 1);
        private final char digit;
        private final int value;
        private RomanDigit(char digit, int value) {
            this.digit = digit;
            this.value = value;
        }
        int getValue() {
            return value;
        }
        char getDigit() {
            return digit;
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
            consumeDigits(romanDigit, romanDigit.getDigit(), romanDigit.getValue());
        }
        return result;
    }

    private void consumeDigits(RomanDigit romanDigit, char digit, int value) {
        while (digitFound(digit)) {
            consumeDigit(value);
        }
    }

    private boolean digitFound(char digit) {
        if (offset >= romanNumber.length()) {
            return false;
        }
        if (romanNumber.charAt(offset) == digit) {
            return true;
        } else {
            return false;
        }
    }

    private void consumeDigit(int value) {
        offset += 1;
        result += value;
    }
}
