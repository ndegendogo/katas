package de.kifaru.ndegendogo.kata.romanNumbers;

import static org.junit.Assert.*;

import org.junit.Test;

public class ConvertToRomanTest {

    @Test
    public void singleDigitI() {
        ConvertToRoman converter = new ConvertToRoman();
        final String roman = converter.arabToRoman("1");
        assertTrue("I".equals(roman));
    }

    @Test
    public void multipleDigitI() {
        ConvertToRoman converter = new ConvertToRoman();
        final String roman = converter.arabToRoman("2");
        assertTrue("II".equals(roman));
    }

    @Test
    public void tripleDigitI() {
        ConvertToRoman converter = new ConvertToRoman();
        final String roman = converter.arabToRoman("3");
        assertTrue("III".equals(roman));
    }
    
    @Test
    public void numberWithDigitV() {
        ConvertToRoman converter = new ConvertToRoman();
        final String roman = converter.arabToRoman("7");
        assertTrue("VII".equals(roman));
    }
}
