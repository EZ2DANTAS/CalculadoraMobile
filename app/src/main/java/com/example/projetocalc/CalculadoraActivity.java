package com.example.projetocalc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projetocalc.R;

public class CalculadoraActivity extends AppCompatActivity {

    EditText caixaResultado;
    double valor1 = 0, valor2 = 0;
    String operador = "";

    TextView operacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        caixaResultado = findViewById(R.id.caixaResultado);

        operacao = findViewById(R.id.operacao);

        setNumero(R.id.btn0, "0");
        setNumero(R.id.btn1, "1");
        setNumero(R.id.btn2, "2");
        setNumero(R.id.btn3, "3");
        setNumero(R.id.btn4, "4");
        setNumero(R.id.btn5, "5");
        setNumero(R.id.btn6, "6");
        setNumero(R.id.btn7, "7");
        setNumero(R.id.btn8, "8");
        setNumero(R.id.btn9, "9");


        setOperador(R.id.btnAdicao, "+");
        setOperador(R.id.btnSubtracao, "-");
        setOperador(R.id.btnMultiplicar, "*");
        setOperador(R.id.btnDividir, "/");


        Button btnResultado = findViewById(R.id.btnResultado);
        btnResultado.setOnClickListener(view -> calcularResultado());


        Button btnLimpar = findViewById(R.id.btnLimpar);
        btnLimpar.setOnClickListener(view -> {
            caixaResultado.setText("");
            valor1 = 0;
            valor2 = 0;
            operador = "";
        });
    }

    private void setNumero(int id, String numero) {
        Button botao = findViewById(id);
        botao.setOnClickListener(view -> {
            String atual = caixaResultado.getText().toString();
            caixaResultado.setText(atual + numero);
        });
    }

    private void setOperador(int id, String op) {
        Button botao = findViewById(id);
        botao.setOnClickListener(view -> {
            try {
                valor1 = Double.parseDouble(caixaResultado.getText().toString());
                operador = op;
                caixaResultado.setText("");
                operacao.setText(op);
            } catch (NumberFormatException e) {
                caixaResultado.setText("Erro");
            }
        });
    }

    private void calcularResultado() {
        try {
            valor2 = Double.parseDouble(caixaResultado.getText().toString());
            double resultado = 0;

            switch (operador) {
                case "+":
                    resultado = valor1 + valor2;
                    break;
                case "-":
                    resultado = valor1 - valor2;
                    break;
                case "*":
                    resultado = valor1 * valor2;
                    break;
                case "/":
                    if (valor2 != 0) {
                        resultado = valor1 / valor2;
                    } else {
                        caixaResultado.setText("Divisão por zero");
                        return;
                    }
                    break;
                default:
                    caixaResultado.setText("Erro");
                    return;
            }

            caixaResultado.setText(String.valueOf(resultado));
        } catch (NumberFormatException e) {
            caixaResultado.setText("Erro");
        }
    }
}
