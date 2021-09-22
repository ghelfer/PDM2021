package com.torre.aula1pdm;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ListaActivity extends Activity {

    private ListView listview;

    String [] de = {"imagem", "destino", "data", "valor"};   //array de chaves
    int [] para = {R.id.tipoViagem, R.id.destino, R.id.data, R.id.valor};  //array de ids do line_item.xml

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        listview = findViewById(R.id.listview);

        //exemplos de dados que podem vir de serviços web
        String [] cidades = {"São Paulo", "Porto Alegre", "Maceió", "Curitiba", "Florianópolis"};
        String [] periodos = {"Março", "Abril", "Junho", "Julho", "Agosto"};
        String [] despesas = {"R$ 2.000,00", "R$ 1.000,00", "R$ 2.500,00", "R$ 1.500,00", "R$ 800,00"};
        int [] tipos = {R.drawable.business, R.drawable.home,R.drawable.vacation,R.drawable.business,R.drawable.business};

        List<Map<String, Object>> dados  = new ArrayList<>();
        for (int i=0; i<cidades.length; i++) {
            Map<String, Object> mapa = new HashMap<>();
            mapa.put("imagem", tipos[i]);
            mapa.put("destino", cidades[i]);
            mapa.put("data", periodos[i]);
            mapa.put("valor", despesas[i]);
            dados.add(mapa);
        }
        SimpleAdapter adapter = new MeuAdapter(this, dados,R.layout.line_item,de,para);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String cidade =  cidades[i];
                String periodo =  periodos[i];
                String despesa =  despesas[i];
                Toast.makeText(ListaActivity.this, cidade +"\n"+ periodo +"\n"+ despesa, Toast.LENGTH_SHORT).show();

            }
        });
    }

    private class MeuAdapter extends SimpleAdapter {
        public MeuAdapter(ListaActivity a, List<Map<String, Object>> b, int c, String[] d, int[] e) {
            super(a,b,c,d,e);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = super.getView(position, convertView, parent);

            if (position %2 == 0) {
                v.setBackgroundColor(Color.parseColor("#AAAAAA"));
            }
            else {
                v.setBackgroundColor(Color.parseColor("#DDDDDD"));
            }

            return v;
        }
    }
}