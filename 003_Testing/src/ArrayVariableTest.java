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

    // initialized arrays
    int[][] var7 = {{0, 1, 2}, {3, 4}, {5, 6, 7, 8}};
    Integer[][] var8 = {{0, 1, 2}, {3, 4}, {5, 6, 7, 8}};
    String[] var9 = {"the", "quick", "brown", "fox"};
    
    @Test
    public void arrayDeclarationsDontAllocateObject() {
        assertNull(var1);
        assertNull(var2);
        assertNull(var3);
        assertNull(var4);
        assertNull(var5);
        assertNull(var6);
    }
}
