package de.kifaru.ndegendogo.kata.romanNumbers;

import static org.junit.Assert.*;

import org.junit.Test;

public class ConvertToRomanTest {

    @Test
    public void singleDigitI() {
        ConvertToRoman converter = new ConvertToRoman("1");
        final String roman = converter.arabToRoman();
        assertTrue("I".equals(roman));
    }

    @Test
    public void multipleDigitI() {
        ConvertToRoman converter = new ConvertToRoman("2");
        final String roman = converter.arabToRoman();
        assertTrue("II".equals(roman));
    }

    @Test
    public void tripleDigitI() {
        ConvertToRoman converter = new ConvertToRoman("3");
        final String roman = converter.arabToRoman();
        assertTrue("III".equals(roman));
    }
    
    @Test
    public void numberWithDigitV() {
        ConvertToRoman converter = new ConvertToRoman("7");
        final String roman = converter.arabToRoman();
        assertTrue("VII".equals(roman));
    }

    @Test
    public void numberWithDigitX() {
        ConvertToRoman converter = new ConvertToRoman("13");
        final String roman = converter.arabToRoman();
        assertTrue("XIII".equals(roman));
    }
}
