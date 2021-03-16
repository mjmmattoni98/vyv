package test;

import main.lab1.FactoresPrimos;

public class FactoresPrimosStub extends FactoresPrimos {
    public long[] firstDescomposition;
    public long[] secondDescomposition;
    public long firstNumber;
    public long secondNumber;

    @Override
    public long[] calcularDescomposicion(long n){
        if (n == firstNumber) return firstDescomposition;
        return secondDescomposition;
    }
}
