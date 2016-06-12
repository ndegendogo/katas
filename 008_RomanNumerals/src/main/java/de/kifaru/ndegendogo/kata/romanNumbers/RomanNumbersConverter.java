package de.kifaru.ndegendogo.kata.romanNumbers;

import java.util.ArrayList;
import java.util.List;

public class RomanNumbersConverter {

    enum RomanDigit {
        // The order of digits must be descending for the algorithm to work correctly.
        DIGIT_M("M", 1000), DIGIT_CM("CM", 900),
        DIGIT_D("D", 500), DIGIT_CD("CD", 400), DIGIT_C("C", 100), DIGIT_XC("XC", 90),
        DIGIT_L("L", 50), DIGIT_XL("XL", 40), DIGIT_X("X", 10), DIGIT_IX("IX", 9),
        DIGIT_V("V", 5), DIGIT_IV("IV", 4), DIGIT_I("I", 1), DIGIT_NONE("", 0);

        private final String glyph;
        private final int value;

        RomanDigit(final String glyph, final int value) {
            this.glyph = glyph;
            this.value = value;
        }

        private int length() {
            return glyph.length();
        }

        private boolean isFirstDigitOf(final String romanNumber) {
            return (romanNumber.startsWith(glyph));
        }
    }

    public int convertToArabicNumber(final String romanNumber) throws RomanNumberFormatException {
        return splitDigits(romanNumber);
    }

    private int splitDigits(final String romanNumber) throws RomanNumberFormatException {
        RomanDigit digit = getFirstDigitOf(romanNumber);
        if (digit.equals(RomanDigit.DIGIT_NONE)) {
            if (isNotConsumedCompletely(romanNumber)) {
                throw new RomanNumberFormatException();
            }
            return digit.value;
        }
        final String remainder = romanNumber.substring(digit.length());
        return digit.value + splitDigits(remainder);
    }
    
    private RomanDigit getFirstDigitOf(final String romanNumber) {
        for (RomanDigit digit: RomanDigit.values()) {
            if (digit.isFirstDigitOf(romanNumber)) {
                return digit;
            }
        }
        return RomanDigit.DIGIT_NONE;
    }

    private boolean isNotConsumedCompletely(final String romanNumber) {
        return romanNumber.length() > 0;
    }
}
