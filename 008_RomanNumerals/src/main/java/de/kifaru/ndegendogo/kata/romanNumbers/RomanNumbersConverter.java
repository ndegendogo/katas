package de.kifaru.ndegendogo.kata.romanNumbers;

import java.util.function.Function;

public class RomanNumbersConverter implements Function<String, Integer> {

    @Override
    public Integer apply(String romanNumber) {
        return convertToArabicNumber(romanNumber);
    }

    static Integer convertToArabicNumber(String romanNumber) {
        int result = 0;
        if (romanNumber.length() > 0) {
            result = matchDigit(romanNumber);
        }
        return result;
    }

    private static int matchDigit(String romanNumber) {
        int result;
        if (romanNumber.charAt(0) == 'I') {
            result = 1;
        } else {
            result = 0;
        }
        return result;
    }
}
