package main.lab1;

public class FactoresPrimos {

    public long[] calcularDescomposicion(long n) {
        // Dado un entero estrictamente positivo, devuelve
        // su descomposición en factores primos
        // Para 50, debería devolver [2, 1, 5, 2]
        // Las posiciones pares (0, 2, 4...) representan
        // los factores primos que componen el número, de
        // menor a mayor; las impares (1, 3, 5...)
        // representan los correspondientes exponentes
        // 50 = 2^1 * 5^2
        // Todavía sin implementar...
        return null;
    }

    public long calcularMCD(long a, long b) {
        if(a < 0 || b < 0) return -1;
        if(a == 0) return b;
        if (b == 0) return a;
        long[] firstDescomposition = calcularDescomposicion(a);
        long[] secondDescomposition = calcularDescomposicion(b);

        long resultMCD = 1;

        for(int i = 0; i < firstDescomposition.length; i+=2)
            for (int j = 0; j < secondDescomposition.length; j+=2)
                if (firstDescomposition[i] == secondDescomposition[j]) {
                    if (firstDescomposition[i + 1] < secondDescomposition[j + 1])
                        resultMCD *= Math.pow(firstDescomposition[i], firstDescomposition[i + 1]);
                    else
                        resultMCD *= Math.pow(secondDescomposition[j], secondDescomposition[j + 1]);
                break;
                }

        return resultMCD;
    }

    public long calcularMCM(long a, long b) {
        // Dados dos enteros estrictamente positivos, devuelve
        // su Mínimo Común Múltiplo
        // Todavía sin implementar...
        return 0;
    }
}
