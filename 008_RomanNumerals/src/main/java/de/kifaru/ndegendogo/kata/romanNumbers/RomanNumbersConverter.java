package de.kifaru.ndegendogo.kata.romanNumbers;

import java.util.function.Function;

public class RomanNumbersConverter implements Function<String, Integer> {

    @Override
    public Integer apply(final String romanNumber) {
        return convertToArabicNumber(romanNumber);
    }

    static Integer convertToArabicNumber(final String romanNumber) {
        int result = 0;
        if (romanNumber.length() > 0) {
            result = matchDigit(romanNumber);
        }
        if (romanNumber.length() > 1) {
            result += matchDigit1(romanNumber);
        }
        return result;
    }

    private static int matchDigit(final String romanNumber) {
        final int offset = 0;
        int result;
        if (romanNumber.charAt(offset) == 'I') {
            result = 1;
        } else {
            result = 0;
        }
        return result;
    }
    private static int matchDigit1(final String romanNumber) {
        final int offset = 1;
        int result;
        if (romanNumber.charAt(offset) == 'I') {
            result = 1;
        } else {
            result = 0;
        }
        return result;
    }
}
