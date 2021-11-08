package com.torre.aula1pdm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;


import org.conscrypt.Conscrypt;

import java.security.Security;
import java.util.HashMap;
import java.util.Map;

public class FbActivity extends AppCompatActivity {

    private TextView txtRt, txtSt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fb);

        txtRt = findViewById(R.id.txtRT);
        txtSt = findViewById(R.id.txtST);
    }

    public void addRtDbClick(View view) {

        Endereco address = new Endereco("Rua B", "Rio Pardo");
        Usuario user = new Usuario("Teste teste", 22, address);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("cadastro3");
        myRef.setValue(user);
        MessageBox("OK");
    }

    public void readRtDbClick(View view) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        database.getReference().child("cadastro").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    MessageBox("Error getting data: " + task.getException());
                } else {
                    String res = task.getResult().getValue().toString();
                    txtRt.setText(res);
                }
            }
        });
    }

    public void addStDbClick(View view) {
        //opção para versoes antigas do Android <= API 20
        Security.insertProviderAt(Conscrypt.newProvider(), 1);
        //

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        Map<String, Object> hosp = new HashMap<>();
        hosp.put("nome", "Teste");
        hosp.put("idade", "25");
        hosp.put("rua", "Rua B");
        hosp.put("cidade", "Rio Pardo");

        // Add a new document with a generated ID
        db.collection("cadastro")
                .add(hosp)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        MessageBox("Document added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        MessageBox("Error adding document " + e.getMessage());
                    }
                });
    }

    private void MessageBox(String s) {
        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
    }

    public void readStDbClick(View view) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("cadastro")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            String str = "";
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                str += document.getId() + " : " + document.getData().toString();
                            }
                            txtSt.setText(str);
                        } else {
                            MessageBox("Error getting documents: " + task.getException());
                        }
                    }
                });

    }


    private class Usuario {

        private String nome;
        private int idade;
        private Endereco endereco;

        public Usuario(String nome, int idade, Endereco endereco) {
            this.nome = nome;
            this.idade = idade;
            this.endereco = endereco;
        }


        public Endereco getEndereco() {
            return endereco;
        }

        public void setEndereco(Endereco endereco) {
            this.endereco = endereco;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public int getIdade() {
            return idade;
        }

        public void setIdade(int idade) {
            this.idade = idade;
        }
    }

    private class Endereco {
        private String rua;
        private String cidade;

        public Endereco(String rua, String cidade) {
            this.rua = rua;
            this.cidade = cidade;
        }

        public String getRua() {
            return rua;
        }

        public void setRua(String rua) {
            this.rua = rua;
        }

        public String getCidade() {
            return cidade;
        }

        public void setCidade(String cidade) {
            this.cidade = cidade;
        }
    }
}