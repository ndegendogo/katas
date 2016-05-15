package de.kifaru.ndegendogo.kata.romanNumbers;

import java.util.function.Function;

public class RomanNumbersConverter implements Function<String, Integer> {

    @Override
    public Integer apply(String romanNumber) {
        return convertToArabicNumber(romanNumber);
    }

    static Integer convertToArabicNumber(String romanNumber) {
        // TODO: implement conversion
        return 0;
    }


}
