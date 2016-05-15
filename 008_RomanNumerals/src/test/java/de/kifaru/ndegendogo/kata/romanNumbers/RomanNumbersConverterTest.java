package de.kifaru.ndegendogo.kata.romanNumbers;

import static org.junit.Assert.*;

import org.junit.Test;

public class RomanNumbersConverterTest {

    @Test
    public void testConvertToArabicNumber() {
        final int expectedResult = 1;
        final Integer actualResult = RomanNumbersConverter.convertToArabicNumber("I");
        assertEquals(expectedResult, actualResult.intValue());
    }

}
