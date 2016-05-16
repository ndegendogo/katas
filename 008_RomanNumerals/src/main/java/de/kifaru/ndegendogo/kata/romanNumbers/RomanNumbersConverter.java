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
            result += matchDigit10(romanNumber, 'X', 10);
        }
        if (romanNumber.length() > offset) {
            result += matchDigit(romanNumber, 'V', 5);
        }
        while (romanNumber.length() > offset) {
            result += matchDigit(romanNumber, 'I', 1);
        }
        return result;
    }

    private int matchDigit(final String romanNumber, char digit, int value) {
        if (romanNumber.charAt(offset) == digit) {
            offset += 1;
            return value;
        } else {
            return 0;
        }
    }
    private int matchDigit10(final String romanNumber, char digit, int value) {
        if (romanNumber.charAt(offset) == digit) {
            offset += 1;
            return value;
        } else {
            return 0;
        }
    }
}
