package de.kifaru.ndegendogo.kata.romanNumbers;

import static org.junit.Assert.*;

import org.junit.Test;

public class ConvertToRomanTest {
    private class TestVector {
        final int arabic;
        final String expectedRoman;
        TestVector(int arabic, String expectedRoman) {
            this.arabic = arabic;
            this.expectedRoman = expectedRoman;
        }
        int getArabic() {
            return arabic;
        }
        String getExpectedRoman() {
            return expectedRoman;
        }
    }

    @Test
    public void singleDigitI() {
        final TestVector vector = new TestVector(1, "I");
        final int arabic = vector.arabic;
        final String expectedRoman = vector.expectedRoman;
        final String roman = ConvertToRoman.arabToRoman(arabic);
        assertEquals(expectedRoman, roman);
    }

    @Test
    public void twoDigitsII() {
        final TestVector vector = new TestVector(2, "II");
        final int arabic = vector.arabic;
        final String expectedRoman = vector.expectedRoman;
        final String roman = ConvertToRoman.arabToRoman(arabic);
        assertEquals(expectedRoman, roman);
    }
}
