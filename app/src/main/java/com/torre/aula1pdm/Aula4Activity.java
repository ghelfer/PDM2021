package com.torre.aula1pdm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Arrays;

public class Aula4Activity extends AppCompatActivity {

    ListView listView;
    Spinner spinner;
    String[] dados = {"água", "luz", "telefone", "internet", "combustível", "aluguel", "seguro", "gás","água", "luz", "telefone", "internet", "combustível", "aluguel", "seguro", "gás","água", "luz", "telefone", "internet", "combustível", "aluguel", "seguro", "gás","água", "luz", "telefone", "internet", "combustível", "aluguel", "seguro", "gás"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aula4);

        spinner = findViewById(R.id.spinner);
        listView = findViewById(R.id.listview);

        ArrayAdapter<String> adapterSpinner = new ArrayAdapter<>(getApplicationContext(),
                R.layout.meu_simple_spinner_item, dados);
        spinner.setAdapter(adapterSpinner);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selecao = dados[i];
                Toast.makeText(getApplicationContext(), selecao, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                //Toast.makeText(getApplicationContext(), "nada selecionado", Toast.LENGTH_LONG).show();
            }
        });

        ArrayAdapter<String> adapterListview = new ArrayAdapter<>(getApplicationContext(),
                R.layout.meu_simple_list_item_1, Arrays.asList(dados));
        listView.setAdapter(adapterListview);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selecao = dados[i];
                Toast.makeText(getApplicationContext(), selecao, Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.meu_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.item1){
            Toast.makeText(this, "item1 clicado", Toast.LENGTH_LONG).show();
            return true;
        }
        return false;
    }
}