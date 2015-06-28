package de.kifaru.ndegendogo.kata.romanNumbers;

import static org.junit.Assert.*;

import org.junit.Test;

public class ConvertToRomanTest {

    @Test
    public void singleDigitI() {
        final String roman = ConvertToRoman.arabToRoman("1");
        assertTrue("I".equals(roman));
    }

    @Test
    public void multipleDigitI() {
        final String roman = ConvertToRoman.arabToRoman("2");
        assertTrue("II".equals(roman));
    }
}
