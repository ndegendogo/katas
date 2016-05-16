package de.kifaru.ndegendogo.kata.romanNumbers;

import java.util.function.Function;

public class RomanNumbersConverter implements Function<String, Integer> {

    private int offset;
    private int result;
    private String romanNumber;

    @Override
    public Integer apply(final String romanNumber) {
        return convertToArabicNumber(romanNumber);
    }

    Integer convertToArabicNumber(final String romanNumber) {
        result = 0;
        offset = 0;
        this.romanNumber = romanNumber;
        consumeDigits('X', 10);
        consumeDigits('V', 5);
        consumeDigits('I', 1);
        return result;
    }

    private void consumeDigits(char digit, int value) {
        while (digitFound(digit)) {
            consumeDigit(value);
        }
    }

    private boolean digitFound(char digit) {
        if (romanNumber.length() <= offset) {
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
