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
public class RomanNumbersConverterTestBadcase {

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {"TATA"},
                {"MCMXCIXT"},
                {"MCMXCTIX"},
        });
    }

    @Parameter(value=0)
    public String actualInput;

    @Test
    public void testConvertToArabicNumber() {
        try {
            RomanNumbersConverter.convertToArabicNumber(actualInput);
            fail();
        } catch (RomanNumberFormatException e) {
            // this is expected
        }
    }
}
