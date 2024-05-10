package com.example.calculator;

public class Calculadora {
    public float sumar (float[] numeros) {
        float sumarTotal = 0;
        for (float numero : numeros) {
            sumarTotal += numero;
        }
        return sumarTotal;
    }

    public float restar (float[] numeros) {
        float restarTotal = numeros[0];
        for (int i = 1; i < numeros.length; i++) {
            restarTotal -= numeros[i];
        }
        return restarTotal;

    }


    public float multiplicar (float[] numeros) {
        float multiTotal = 1;
        for (float numero : numeros) {
            multiTotal *= numero;
        }
        return multiTotal;
    }

    public float dividir (float[] numeros) {
        float divTotal = numeros[0];
        for (int i = 1; i < numeros.length; i++) {
            if (numeros[i] != 0) {
                divTotal /= numeros[i];
            } else {
                throw new ArithmeticException("División por cero");
            }
        }
        return divTotal;
    }

    public float porcentaje (float[] numeros) {
        float porTotal;
        if (numeros.length != 2) {
            throw new ArithmeticException("Deben haber dos números exactos");
        } else {
           porTotal = (numeros[0] * numeros[1]) / 100;
        }
        return porTotal;
    }

}
