package com.example.sensores;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListarActivity extends AppCompatActivity {

    private ListView listaSensores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_listar);

        listaSensores = (ListView) findViewById( R.id.listaSensores );

        Intent intent = getIntent();
        String[] sensores = intent.getStringArrayExtra("sensores");

        ArrayAdapter<String> adapter = new ArrayAdapter<
                String>(this, android.R.layout.simple_list_item_1, sensores);

        listaSensores.setAdapter(adapter);
    }
}
