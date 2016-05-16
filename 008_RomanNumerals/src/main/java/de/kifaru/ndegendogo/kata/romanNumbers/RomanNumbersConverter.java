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
        while (matchDigit(romanNumber, 'X', 10));
        while (matchDigit(romanNumber, 'V', 5));
        while (matchDigit(romanNumber, 'I', 1));
        return result;
    }

    private boolean matchDigit(final String romanNumber, char digit, int value) {
        if (romanNumber.length() <= offset) {
            return false;
        }
        if (romanNumber.charAt(offset) == digit) {
            offset += 1;
            result += value;
            return true;
        } else {
            return false;
        }
    }
}
