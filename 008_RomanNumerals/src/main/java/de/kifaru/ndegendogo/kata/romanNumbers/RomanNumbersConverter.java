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

        int length() {
            return glyph.length();
        }

        boolean found(final String romanNumber, int offset) {
            return romanNumber.startsWith(glyph, offset);
        }

        void consumeSingle(ConverterState state) {
            state.offset += length();
            state.result += value;
        }
    }

    public int convertToArabicNumber(final String romanNumber) throws RomanNumberFormatException {
        final ConverterState state = new ConverterState();
        for (RomanDigit digit: RomanDigit.values()) {
            consume(digit, state, romanNumber);
        }
        if (allDigitsConsumed(romanNumber, state)) {
            return state.result;
        } else {
            throw new RomanNumberFormatException();
        }
    }

    private void consume(final RomanDigit digit, final ConverterState state, final String romanNumber) {
        while (digit.found(romanNumber, state.offset)) {
            digit.consumeSingle(state);
        }
    }

    private boolean allDigitsConsumed(final String romanNumber, final ConverterState state) {
        return state.offset == romanNumber.length();
    }
}
