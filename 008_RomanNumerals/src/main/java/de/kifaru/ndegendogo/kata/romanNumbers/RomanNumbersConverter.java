package de.kifaru.ndegendogo.kata.romanNumbers;

public class RomanNumbersConverter {

    class ConverterState {
        private int offset;
        private int result;

        ConverterState() {
            result = 0;
            offset = 0;
        }

        private int finishConversion(final String romanNumber) throws RomanNumberFormatException {
            if (allDigitsConsumed(romanNumber)) {
                return result;
            } else {
                throw new RomanNumberFormatException();
            }
        }

        private boolean allDigitsConsumed(final String romanNumber) {
            return offset == romanNumber.length();
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

        private void addDigits(final String romanNumber, final ConverterState state) {
            while (isNextDigitAt(romanNumber, state.offset)) {
                add(state);
            }
        }

        private boolean isNextDigitAt(final String romanNumber, final int offset) {
            return romanNumber.startsWith(glyph, offset);
        }

        private void add(final ConverterState state) {
            state.offset += length();
            state.result += value;
        }
    }

    public int convertToArabicNumber(final String romanNumber) throws RomanNumberFormatException {
        final ConverterState state = new ConverterState();
        for (RomanDigit digit: RomanDigit.values()) {
            digit.addDigits(romanNumber, state);
        }
        return state.finishConversion(romanNumber);
    }
}
