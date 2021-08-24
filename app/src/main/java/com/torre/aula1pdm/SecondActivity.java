package com.torre.aula1pdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView txt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        long valor = intent.getLongExtra("key", 10L);

        txt2 = findViewById(R.id.txtRotulo2);

        txt2.setText(String.valueOf(valor));


        Log.d("TESTE", "onCreate SecondActivity disparado!");
    }





    @Override
    protected void onStart() {
        super.onStart();
        Log.d("TESTE", "onStart SecondActivity disparado!");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("TESTE", "onRestart SecondActivity disparado!");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("TESTE", "onResume SecondActivity disparado!");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("TESTE", "onPause SecondActivity isparado!");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("TESTE", "onStop SecondActivity disparado!");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("TESTE", "onDestroy SecondActivity disparado!");
    }

    public void abrirTela2Click(View view) {
        setContentView(R.layout.tela2);
    }

    public void voltarClick(View view) {
        setContentView(R.layout.activity_second);
    }
}