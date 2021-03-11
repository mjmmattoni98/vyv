package test;

import main.lab1.FactoresPrimos;

public class FactoresPrimosStub extends FactoresPrimos {
    public long[] firstDescomposition;
    public long[] secondDescomposition;
    private int count = 0;

    @Override
    public long[] calcularDescomposicion(long n){
        long[] descomposition;
        if(count % 2 == 0)
            descomposition = firstDescomposition;
        else
            descomposition = secondDescomposition;
        count++;
        return descomposition;
    }
}
