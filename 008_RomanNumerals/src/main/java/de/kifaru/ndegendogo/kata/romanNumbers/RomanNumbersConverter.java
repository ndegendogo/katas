package de.kifaru.ndegendogo.kata.romanNumbers;

public class RomanNumbersConverter {

    class ConverterState {
        private int offset;
        private int result;

        ConverterState() {
            result = 0;
            offset = 0;
        }

        private int finishConversion(int length) throws RomanNumberFormatException {
            if (allDigitsConsumed(length)) {
                return result;
            } else {
                throw new RomanNumberFormatException();
            }
        }

        private boolean allDigitsConsumed(int length) {
            return offset == length;
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

        private void addDigits(final String romanNumber, final char[] romanNumberArray, final ConverterState state) {
            while (isNextDigitAt(romanNumber, romanNumberArray, state.offset)) {
                add(state);
            }
        }

        private boolean isNextDigitAt(final String romanNumber, final char[] romanNumberArray, final int arrayOffset) {
            final int arrayLength = romanNumberArray.length;
            if (arrayOffset >= arrayLength) {
                return false;
            }
            final int tailLength = arrayLength - arrayOffset;
            if (tailLength < length()) {
                return false;
            }
            for (int i = 0; i < length(); i ++) {
                if (romanNumberArray[arrayOffset + i] != glyph.charAt(i)) {
                    return false;
                }
            }
            return true;
        }

        private void add(final ConverterState state) {
            state.offset += length();
            state.result += value;
        }
    }

    public int convertToArabicNumber(final String romanNumber) throws RomanNumberFormatException {
        final ConverterState state = new ConverterState();
        final char[] romanNumberArray = romanNumber.toCharArray();
        for (RomanDigit digit: RomanDigit.values()) {
            digit.addDigits(romanNumber, romanNumberArray, state);
        }
        return state.finishConversion(romanNumber.length());
    }
}
