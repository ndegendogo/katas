package de.kifaru.ndegendogo.kata.romanNumbers;

import static org.junit.Assert.*;

import org.junit.Test;

public class RomanNumbersConverterTest {

    @Test
    public void testConvertToArabicNumber() {
        final String actualInput = "I";
        final int expectedResult = 1;
        final Integer actualResult = RomanNumbersConverter.convertToArabicNumber(actualInput);
        assertEquals(expectedResult, actualResult.intValue());
    }

}
