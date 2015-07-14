import java.lang.reflect.Array;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArrayVariableTest {

    // one-dimensional array declarations
    int[] var1;
    int var2[];     // this format is discouraged
    Array var3;

    // two-dimensional array declarations
    int[][] var4;
    int var5[][];   // this format is discouraged
    int[] var6[];   // and this format is even more confusing

    @Test
    public void test() {
        fail();
    }

}
