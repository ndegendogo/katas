package de.kifaru.ndegendogo.kata.romanNumbers;

import static org.junit.Assert.*;

import org.junit.Test;

public class RomanNumbersConverterTest {

    @Test
    public void testConvertToArabicNumber() {
        assertEquals(1, RomanNumbersConverter.convertToArabicNumber("I").intValue());
    }

}
