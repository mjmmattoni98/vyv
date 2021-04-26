package test.lab2;

import main.lab2.Prima;
import main.lab2.TablaDeportista;
import main.lab2.TablaEquipo;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class PruebaSumarPrima {
    private static Prima p;
    private TablaDeportista td;
    private TablaEquipo te;
    private String inputDeportista;
    private String inputEquipo;
    private int expectedOutput;
    private static final float umbralFicha = 2000;
    private static final float prima = 100;
    private final String path = "C:\\Users\\javie\\Documents\\VyV\\src\\test\\lab2\\resources\\";

    public PruebaSumarPrima(String inputDeportista, String inputEquipo, int expectedOutput){
        this.inputDeportista = inputDeportista;
        this.inputEquipo = inputEquipo;
        this.expectedOutput = expectedOutput;
    }

    @BeforeClass
    public static void crearPrima(){
        p = new Prima(prima, umbralFicha);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(
                new Object[][] {
                        {"deportistas1.txt", "equipos1.txt", 2},
                        {"deportistas1.txt", "equiposVacia.txt", 1},
                        {"deportistasVacia.txt", "equiposVacia.txt", 1},
                        {"deportistas2.txt", "equipos2.txt", 0},
                }
        );
    }

    @Test
    public void testSumarPrima(){
        td = new TablaDeportista(path+inputDeportista);
        te = new TablaEquipo(path+inputEquipo);
        assertEquals(expectedOutput, p.sumarPrima(td, te));
    }

}
