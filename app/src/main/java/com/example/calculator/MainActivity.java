package com.example.calculator;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.text.NumberFormat;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    EditText value1, value2;
    TextView result;
    Button sum, res, multi, div, percent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        sum = findViewById(R.id.sum);
        res = findViewById(R.id.res);
        multi = findViewById(R.id.multi);
        div = findViewById(R.id.div);
        percent = findViewById(R.id.porcentaje);
        value1 = findViewById(R.id.valor1);
        result = findViewById(R.id.result);

        sum.setOnClickListener(v -> operaciones("1"));

        res.setOnClickListener(v -> operaciones("2"));

        multi.setOnClickListener(v -> operaciones("3"));

        div.setOnClickListener(v -> operaciones("4"));

        percent.setOnClickListener(v -> operaciones("5"));

        }
    private void operaciones(String operador) {
        String usuarioInput = value1.getText().toString();
        String[] valorStr = usuarioInput.split(" ");

        float[] numeros = new float[valorStr.length];

        for(int i = 0; i < valorStr.length; i++ ) {
            numeros[i] = Float.parseFloat(valorStr[i]);
        }
        Calculadora calculadora = new Calculadora();
        float resultado = 0;

        switch (operador) {
            case "1":
                resultado = calculadora.sumar(numeros);
                break;
            case "2":
                resultado = calculadora.restar(numeros);
                break;
            case "3":
                resultado = calculadora.multiplicar(numeros);
                break;
            case "4":
                if (numeros.length > 1) {
                    if (numeros[1] != 0) {
                        resultado = calculadora.dividir(numeros);
                    } else {
                        result.setText("Error: No se puede dividir por cero");
                        return;
                    }
                } else {
                    result.setText("Error: Se requieren al menos dos números para la división");
                    return;
                }
                break;
            case "5":
                if (numeros.length != 2) {
                    new ArithmeticException("Deben haber dos números exactos");
                } else {
                    resultado = calculadora.porcentaje(numeros);
                }
        }
        NumberFormat resultadoExacto = NumberFormat.getInstance();
        String resultadoFormateado = resultadoExacto.format(resultado);
        if (operador.equals("4") && resultado % 1 != 0) {
            result.setText(String.valueOf(resultado));
        } else {
            result.setText(resultadoFormateado);
        }

    }

}


