package de.kifaru.ndegendogo.kata.romanNumbers;

public class RomanNumbersConverter {

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

        private boolean isFirstDigitOf(final String romanNumber) {
            return (romanNumber.startsWith(glyph));
        }
    }

    public static int convertToArabicNumber(final String romanNumber) throws RomanNumberFormatException {
        return convertDigits(romanNumber);
    }

    private static int convertDigits(final String romanNumber) throws RomanNumberFormatException {
        if (isConvertedCompletely(romanNumber)) {
            return 0;
        }
        final RomanDigit digit = getFirstDigitOf(romanNumber);
        return digit.value + convertDigits(remainderAfterDigit(romanNumber, digit));
    }

    private static boolean isConvertedCompletely(final String romanNumber) {
        return romanNumber.isEmpty();
    }
    
    private static RomanDigit getFirstDigitOf(final String romanNumber) throws RomanNumberFormatException {
        for (RomanDigit digit: RomanDigit.values()) {
            if (digit.isFirstDigitOf(romanNumber)) {
                return digit;
            }
        }
        throw new RomanNumberFormatException();
    }

    private static String remainderAfterDigit(final String romanNumber, final RomanDigit digit) {
        return romanNumber.substring(digit.length());
    }
}
