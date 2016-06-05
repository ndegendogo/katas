package de.kifaru.ndegendogo.kata.romanNumbers;

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

        private boolean isNextDigitAt(final char[] romanNumberArray, final int arrayOffset) {
            final int arrayLength = romanNumberArray.length;
            final int tailLength = arrayLength - arrayOffset;
            if (tailLength <= 0 || tailLength < length()) {
                return false;
            }
            for (int i = 0; i < length(); i ++) {
                if (romanNumberArray[arrayOffset + i] != glyph.charAt(i)) {
                    return false;
                }
            }
            return true;
        }
    }

    public int convertToArabicNumber(final String romanNumber) throws RomanNumberFormatException {
        final char[] romanNumberArray = romanNumber.toCharArray();
        int offset = 0;
        int result = 0;
        for (RomanDigit digit: RomanDigit.values()) {
            while (digit.isNextDigitAt(romanNumberArray, offset)) {
                offset += digit.length();
                result += digit.value;
            }
        }
        if (offset == romanNumberArray.length) {
            return result;
        } else {
            throw new RomanNumberFormatException();
        }
    }
}
