package com.example.projetocalc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText usuario;
    private EditText senha;
    private Button entrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        usuario = findViewById(R.id.txtUsuario);
        senha = findViewById(R.id.txtSenha);
        entrar =  findViewById(R.id.btnEntrar);


        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(usuario.getText().toString().equals("admin") && senha.getText().toString().equals("admin"))
                {
                    Intent intent = new Intent(MainActivity.this, CalculadoraActivity.class);
                    startActivity(intent);
                }
            }
        });

    }


}