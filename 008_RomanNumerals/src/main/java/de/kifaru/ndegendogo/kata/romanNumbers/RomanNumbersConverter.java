package de.kifaru.ndegendogo.kata.romanNumbers;

import java.util.ArrayList;
import java.util.List;

public class RomanNumbersConverter {

    class ConverterState {
        private int offset;
        private int result;

        ConverterState() {
            result = 0;
            offset = 0;
        }
    }

    enum RomanDigit {
        // The order of digits must be descending for the algorithm to work correctly.
        DIGIT_M("M", 1000), DIGIT_CM("CM", 900),
        DIGIT_D("D", 500), DIGIT_CD("CD", 400), DIGIT_C("C", 100), DIGIT_XC("XC", 90),
        DIGIT_L("L", 50), DIGIT_XL("XL", 40), DIGIT_X("X", 10), DIGIT_IX("IX", 9),
        DIGIT_V("V", 5), DIGIT_IV("IV", 4), DIGIT_I("I", 1);

        private final String glyph;
        private final int value;

        RomanDigit(final String glyph, final int value) {
            this.glyph = glyph;
            this.value = value;
        }

        private int length() {
            return glyph.length();
        }

        private boolean isFirstDigitOf(String romanNumber) {
            return (romanNumber.startsWith(glyph));
        }
    }

    public int convertToArabicNumber(String romanNumber) throws RomanNumberFormatException {
        final List<RomanDigit> digitList = new ArrayList<RomanDigit>();
        for (RomanDigit digit: RomanDigit.values()) {
            while (digit.isFirstDigitOf(romanNumber)) {
                romanNumber = romanNumber.substring(digit.length());
                digitList.add(digit);
            }
        }
        if (0 != romanNumber.length()) {
            throw new RomanNumberFormatException();
        }

        int result = addDigits(digitList);
        return result;
    }

    private int addDigits(final List<RomanDigit> digitList) {
        int result = 0;
        for (RomanDigit digit: digitList) {
            result += digit.value;
        }
        return result;
    }
}
