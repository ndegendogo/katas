package de.kifaru.ndegendogo.kata.romanNumbers;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class RomanNumbersConverterTest {

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {"I", 1},
                {"", 0},
        });
    }

    @Parameter(value=0)
    public String actualInput;

    @Parameter(value=1)
    public int expectedResult;

    @Test
    public void testConvertToArabicNumber() {
        final Integer actualResult = RomanNumbersConverter.convertToArabicNumber(actualInput);
        assertEquals(expectedResult, actualResult.intValue());
    }
}
