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
            result += matchDigit10(romanNumber, 'X');
        }
        if (romanNumber.length() > offset) {
            result += matchDigit5(romanNumber, 'V');
        }
        while (romanNumber.length() > offset) {
            result += matchDigit(romanNumber, 'I');
        }
        return result;
    }

    private int matchDigit(final String romanNumber, char digit) {
        int value;
        if (romanNumber.charAt(offset) == digit) {
            value = 1;
            offset += 1;
        } else {
            value = 0;
        }
        return value;
    }
    private int matchDigit5(final String romanNumber, char digit) {
        int value;
        if (romanNumber.charAt(offset) == digit) {
            value = 5;
            offset += 1;
        } else {
            value = 0;
        }
        return value;
    }
    private int matchDigit10(final String romanNumber, char digit) {
        int value;
        if (romanNumber.charAt(offset) == digit) {
            value = 10;
            offset += 1;
        } else {
            value = 0;
        }
        return value;
    }
}
