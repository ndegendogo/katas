package de.kifaru.ndegendogo.kata.romanNumbers;

import static org.junit.Assert.*;

import org.junit.Test;

public class ConvertToRomanTest {

    @Test
    public void singleDigitI() {
        final int arabic = 1;
        final String expectedRoman = "I";
        final String roman = ConvertToRoman.arabToRoman(arabic);
        assertEquals(expectedRoman, roman);
    }

    @Test
    public void twoDigitsII() {
        final int arabic = 2;
        final String expectedRoman = "II";
        final String roman = ConvertToRoman.arabToRoman(arabic);
        assertEquals(expectedRoman, roman);
    }
}
