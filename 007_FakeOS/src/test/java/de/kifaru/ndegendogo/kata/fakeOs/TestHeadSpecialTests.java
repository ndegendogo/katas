package de.kifaru.ndegendogo.kata.fakeOs;

import java.util.Arrays;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class TestHeadSpecialTests {

    @Parameters(name = "{0}")
    public static Iterable<Object[]>data() {
        return Arrays.asList(new Object[][] {
        });
    }
    
    private final String testName;

    public TestHeadSpecialTests(final String testName) {
        this.testName = testName;
    }

}
