package test;

import static org.junit.Assert.assertEquals;

import main.lab1.FactoresPrimos;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class PruebaMCD {
    private static FactoresPrimosStub stub;
    private long[] input;
    private long expectedOutput;
    private long[][] dependencies;

    public PruebaMCD(long[] input, long expectedOutput, long[][] dependencies){
        this.input = input;
        this.expectedOutput = expectedOutput;
        this.dependencies = dependencies;
    }

    @BeforeClass
    public static void crearFactoresPrimos(){
        stub = new FactoresPrimosStub();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(
                new Object[][] {
                        {new long[]{4, 6}, 2L, new long[][]{{2, 2}, {2, 1, 3, 1}}},
                        {new long[]{7, 3}, 1L, new long[][]{{7, 1}, {3, 1}}},
                        {new long[]{4, 4}, 4L, new long[][]{{2, 2}, {2, 2}}},
                        {new long[]{13, 13}, 13L, new long[][]{{13, 1}, {13, 1}}},
                        {new long[]{0, 8}, -1L, new long[][]{{}, {2, 3}}},
                        {new long[]{4, 0}, -1L, new long[][]{{2, 2}, {}}},
                        {new long[]{0, 0}, -1L, new long[][]{{}, {}}},
                        {new long[]{5, -7}, -1L, new long[][]{{5, 1}, {}}},
                        {new long[]{-4, 9}, -1L, new long[][]{{}, {3, 2}}},
                        {new long[]{-10, -3}, -1L, new long[][]{{}, {}}}
                }
        );
    }

    @Test
    public void testMCD(){
        stub.firstDescomposition = dependencies[0];
        stub.secondDescomposition = dependencies[1];
        stub.firstNumber = input[0];
        stub.secondNumber = input[1];
        assertEquals(expectedOutput, stub.calcularMCD(input[0], input[1]));
    }
}
