package com.impagno.firebasedemo;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.impagno.firebasedemo.model.Produto;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference ref = database.getReference();

    private TextView txtView;
    private EditText txtNome;
    private EditText txtValor;
    private Button button;
    private Button btnLogout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final DatabaseReference child = ref.child("produtos");
        txtNome = findViewById(R.id.txtNome);
        txtValor = findViewById(R.id.txtValor);
        txtView = findViewById(R.id.txtLista);
        button = findViewById(R.id.button);
        btnLogout = findViewById(R.id.btnLogout);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = txtNome.getText().toString();
                String valor = txtValor.getText().toString();
                child.child(UUID.randomUUID().toString()).setValue(new Produto(nome, valor));
                txtNome.setText("");
                txtNome.setFocusable(true);
                txtValor.setText("");
            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            }
        });

        // creating a map with the values
        //Map<String, Produto> produtos = new HashMap<>();
        //produtos.put(UUID.randomUUID().toString(), new Produto("Relogio", 23.48));
        //produtos.put(UUID.randomUUID().toString(), new Produto("Esteira Elétrica", 55.32));
        //produtos.put(UUID.randomUUID().toString(), new Produto("Cadeira", 89.99));

        // put the values into the database
        //child.setValue(produtos);

        child.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                txtView.setText(dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
