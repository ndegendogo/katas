package de.kifaru.ndegendogo.kata.romanNumbers;

import java.util.function.Function;

public class RomanNumbersConverter implements Function<String, Integer> {

    private int offset;
    @Override
    public Integer apply(final String romanNumber) {
        return convertToArabicNumber(romanNumber);
    }

    Integer convertToArabicNumber(final String romanNumber) {
        int result = 0;
        offset = 0;
        if (romanNumber.length() > offset) {
            result += matchDigit5(romanNumber);
        }
        while (romanNumber.length() > offset) {
            result += matchDigit(romanNumber, offset);
            offset += 1;
        }
        return result;
    }

    private int matchDigit(final String romanNumber, final int offset) {
        int value;
        if (romanNumber.charAt(offset) == 'I') {
            value = 1;
        } else {
            value = 0;
        }
        return value;
    }
    private int matchDigit5(final String romanNumber) {
        int value;
        if (romanNumber.charAt(offset) == 'V') {
            value = 5;
            offset += 1;
        } else {
            value = 0;
        }
        return value;
    }
}
