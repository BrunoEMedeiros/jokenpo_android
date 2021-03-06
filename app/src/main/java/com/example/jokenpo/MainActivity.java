package com.example.jokenpo;
import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

     ImageView escolhaJogo;
     ImageView pedra;
     ImageView papel;
     ImageView tesoura;
     TextView resultado, vitorias, derrotas;


    public void opcaoSelecionada(String escolhaUsuario){



        String[] opcoes = new String[] {"pedra","papel","tesoura"};
        Random random = new Random();
        int num = random.nextInt(3);
        String escolhaApp = opcoes[num];

        switch (escolhaApp)
        {
            case "pedra":
                escolhaJogo.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                escolhaJogo.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                escolhaJogo.setImageResource(R.drawable.tesoura);
                break;
        }

        //Validando ganhador
        if(
                (escolhaUsuario == "pedra" && escolhaApp == "tesoura") || (escolhaUsuario == "tesoura" && escolhaApp == "papel") || (escolhaUsuario == "papel" && escolhaApp == "pedra")
        )

        {
            resultado.setText("Voce Ganhou!! Parabéns!");
            //app Ganhador
        }else if((escolhaApp == "pedra" && escolhaUsuario == "tesoura") || (escolhaApp == "tesoura" && escolhaUsuario == "papel") || (escolhaApp == "papel" && escolhaUsuario == "pedra"))
        {

            resultado.setText("Voce perdeu!!");

        }else {

            resultado.setText("Empate!");
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        escolhaJogo = findViewById(R.id.escolhaJogo);
        pedra = findViewById(R.id.pedra);
        papel = findViewById(R.id.papel);
        tesoura = findViewById(R.id.tesoura);
        resultado = findViewById(R.id.resultado);


        pedra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opcaoSelecionada("pedra");
            }
        });
        papel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opcaoSelecionada("papel");
            }
        });
        tesoura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opcaoSelecionada("tesoura");
            }
        });

    }
}
