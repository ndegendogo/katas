package de.kifaru.ndegendogo.kata.romanNumbers;

import java.util.function.Function;

public class RomanNumbersConverter implements Function<String, Integer> {

    @Override
    public Integer apply(String romanNumber) {
        return convertToArabicNumber(romanNumber);
    }

    static Integer convertToArabicNumber(String romanNumber) {
        int result = 0;
        if (romanNumber.charAt(0) == 'I') {
            result = 1;
        }
        return result;
    }
}
