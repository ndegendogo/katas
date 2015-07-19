import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArrayVariableTest {

    // one-dimensional array declarations
    int[] var1;
    int var2[];     // this format is discouraged
//    Array var3;   => this is not an array!!

    // two-dimensional array declarations
    int[][] var4;
    int var5[][];   // this format is discouraged
    int[] var6[];   // and this format is even more confusing

    // initialized arrays
    int[][] var7 = {{0, 1, 2}, {3, 4}, {5, 6, 7, 8}};
    Integer[][] var8 = {{0, 1, 2}, {3, 4}, {5, 6, 7, 8}};
    String[] var9 = {"the", "quick", "brown", "fox"};
    int[] var10 = {1, 2, 3, 4, 7};
    Integer[] var11 = {1, 2, 3, 4, 7};

    // arrays allocated at runtime
    int[] var12 = new int[4];
    int[][] var13 = new int[5][6];
    Integer[][] var14 = new Integer[3][];
    
    
    @Test
    public void arrayDeclarationsDontAllocateObject() {
        assertNull(var1);
        assertNull(var2);
        assertNull(var4);
        assertNull(var5);
        assertNull(var6);
    }
    
    @Test
    public void variableNumberOfMethodParams() {
        String[] parameters = {"Hello", "world!"};
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < parameters.length; i++) {
            result.append(parameters[i]);
            result.append(' ');
        }
        assertEquals("Hello world! ", result);
    }

}
