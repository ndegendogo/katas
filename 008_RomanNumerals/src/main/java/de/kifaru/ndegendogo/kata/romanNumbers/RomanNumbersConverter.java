package de.kifaru.ndegendogo.kata.romanNumbers;

public class RomanNumbersConverter {

    private class ConverterState {
        private int offset;
        private int result;
        private String romanNumber;
    }

    private ConverterState state = new ConverterState();

    private enum RomanDigit {
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
        int getValue() {
            return value;
        }
        String getGlyph() {
            return glyph;
        }
    }

    public synchronized Integer convertToArabicNumber(final String romanNumber) throws RomanNumberFormatException {
        init(romanNumber);
        for (RomanDigit digit: RomanDigit.values()) {
            consume(digit);
        }
        if (allDigitsConsumed()) {
            return state.result;
        } else {
            throw new RomanNumberFormatException();
        }
    }

    private void init(final String romanNumber) {
        state.result = 0;
        state.offset = 0;
        state.romanNumber = romanNumber;
    }

    private void consume(final RomanDigit digit) {
        while (found(digit.getGlyph())) {
            consumeSingle(digit);
        }
    }

    private boolean found(String glyph) {
        return state.romanNumber.startsWith(glyph, state.offset);
    }

    private void consumeSingle(RomanDigit digit) {
        state.offset += digit.getGlyph().length();
        state.result += digit.getValue();
    }

    private boolean allDigitsConsumed() {
        return state.offset == state.romanNumber.length();
    }

}
