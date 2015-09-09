package de.kifaru.ndegendogo.kata.fakeOs;

import java.util.Arrays;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class TestHeadSpecialTests extends BaseTestHead {

    @Parameters(name = "{0}")
    public static Iterable<Object[]>data() {
        return Arrays.asList(new Object[][] {
        });
    }
    
    public TestHeadSpecialTests(final String testName, final String[] inputLines, final String[] expectedLines) {
        super(testName, inputLines, expectedLines);
    }

}
