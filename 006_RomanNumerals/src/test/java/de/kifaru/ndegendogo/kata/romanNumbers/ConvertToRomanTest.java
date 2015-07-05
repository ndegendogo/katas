package de.kifaru.ndegendogo.kata.romanNumbers;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class ConvertToRomanTest {
    private int arabic;
    private String expectedRoman;
    
    public ConvertToRomanTest(int arabic, String expectedRoman) {
        this.arabic = arabic;
        this.expectedRoman = expectedRoman; 
    }
            
    @Parameters(name = "{index}: {0} => {1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] {
            { 1, "I" },
            { 2, "II" },
            { 3, "III" },
            { 7, "VII" },
            { 13, "XIII" },
            { 61, "LXI" },
            { 2777, "MMDCCLXXVII" },
            { 4, "IV" },
            { 1444, "MCDXLIV" },
            { 2999, "MMCMXCIX" },
        } );
    }
    
    @Test
    public void testConversion() {
        assertEquals(expectedRoman, ConvertToRoman.convert(arabic));
    }
}
