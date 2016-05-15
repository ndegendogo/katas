package de.kifaru.ndegendogo.kata.romanNumbers;

import java.util.function.Function;

public class RomanNumbersConverter implements Function<String, Integer> {

    @Override
    public Integer apply(String string) {
        return convertRomanToArabicNumber(string);
    }

    static Integer convertRomanToArabicNumber(String romanNumber) {
        // TODO: implement conversion
        return 0;
    }


}
