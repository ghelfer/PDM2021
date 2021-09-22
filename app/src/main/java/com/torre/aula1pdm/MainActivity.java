package com.torre.aula1pdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView txt;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btnSalvar);
        txt = findViewById(R.id.txtRotulo);

        btn.setOnClickListener(this);
        txt.setOnClickListener(this);

        Log.d("TESTE", "onCreate MainActivity disparado!");
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d("TESTE", "onStart MainActivity disparado!");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("TESTE", "onRestart MainActivity disparado!");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("TESTE", "onResume MainActivity disparado!");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("TESTE", "onPause MainActivity isparado!");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("TESTE", "onStop MainActivity disparado!");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("TESTE", "onDestroy MainActivity disparado!");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSalvar:
                disparaEvento1();
                break;
            case R.id.txtRotulo:
                Log.d("TESTE", "Cliquei no textview");
                break;
        }


    }

    private void disparaEvento1() {
        txt.setText("Segunda-feira, melhor dia da semana!");
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        //long l = Long.parseLong("9082021");
        intent.putExtra("key", 9082021);
        startActivity(intent);

    }

    public void botao2Click(View view) {
        Toast.makeText(this,"Cliquei no botao", Toast.LENGTH_SHORT).show();
        //txt.setVisibility(View.GONE);
        Uri uri = Uri.parse("https://unisc.br");
        Intent i = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(i);
    }

    public void ex1Click(View view) {
        Intent intent = new Intent(MainActivity.this, Exercicio31.class);
        startActivity(intent);
    }

    public void ex2Click(View view) {
        Intent intent = new Intent(MainActivity.this, Exercicio32.class);
        startActivity(intent);
    }

    public void ex3Click(View view) {
        Intent intent = new Intent(MainActivity.this, Exercicio33.class);
        startActivity(intent);
    }

    public void ex4Click(View view) {
        Intent intent = new Intent(MainActivity.this, Exercicio34.class);
        startActivity(intent);
    }

    public void aula4Click(View view) {
        Intent intent = new Intent(MainActivity.this, Aula4Activity.class);
        startActivity(intent);
    }

    public void aula5Click(View view) {
        Intent intent = new Intent(MainActivity.this, ListaActivity.class);
        startActivity(intent);
    }
}