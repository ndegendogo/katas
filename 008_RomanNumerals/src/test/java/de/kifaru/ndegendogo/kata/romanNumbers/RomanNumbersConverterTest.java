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
                {"", 0},
                {"I", 1},
                {"II", 2},
                {"III", 3},
                {"V", 5},
                {"VI", 6},
                {"X", 10},
                {"XV", 15},
                {"XVIII", 18},
                {"XX", 20},
                {"L", 50},
                {"C", 100},
                {"D", 500},
        });
    }

    @Parameter(value=0)
    public String actualInput;

    @Parameter(value=1)
    public int expectedResult;

    @Test
    public void testConvertToArabicNumber() {
        final Integer actualResult = new RomanNumbersConverter().convertToArabicNumber(actualInput);
        assertEquals(expectedResult, actualResult.intValue());
    }
}
