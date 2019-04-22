package com.impagno.firebasedemo;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseReference child = ref.child("produtos");
        txtView = findViewById(R.id.textView);

        // creating a map with the values
        //Map<String, Produto> produtos = new HashMap<>();
        //produtos.put(UUID.randomUUID().toString(), new Produto("Relogio", 23.48));
        //produtos.put(UUID.randomUUID().toString(), new Produto("Esteira Elétrica", 55.32));
        //produtos.put(UUID.randomUUID().toString(), new Produto("Cadeira", 89.99));

        // put the values into the database
        //child.setValue(produtos);

        child.addListenerForSingleValueEvent(new ValueEventListener() {
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
