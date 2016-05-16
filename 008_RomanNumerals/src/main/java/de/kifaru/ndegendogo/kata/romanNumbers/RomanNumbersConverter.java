package de.kifaru.ndegendogo.kata.romanNumbers;

import java.util.function.Function;

public class RomanNumbersConverter implements Function<String, Integer> {

    @Override
    public Integer apply(final String romanNumber) {
        return convertToArabicNumber(romanNumber);
    }

    Integer convertToArabicNumber(final String romanNumber) {
        int result = 0;
        int offset = 0;
        while (romanNumber.length() > offset) {
            result += matchDigit(romanNumber, offset);
            offset += 1;
        }
        return result;
    }

    private static int matchDigit(final String romanNumber, final int offset) {
        int value;
        if (romanNumber.charAt(offset) == 'I') {
            value = 1;
        } else {
            value = 0;
        }
        return value;
    }
}
