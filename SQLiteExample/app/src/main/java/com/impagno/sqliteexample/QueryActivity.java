package com.impagno.sqliteexample;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.impagno.sqliteexample.controller.DatabaseController;

public class QueryActivity extends AppCompatActivity {

    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query);

        list = findViewById(R.id.listView);

        DatabaseController db = new DatabaseController(getApplicationContext());
        Cursor cursor = db.list();

        String[] nomeCampos = new String[] {DatabaseCreation.AUTOR, DatabaseCreation.TITULO};
        int[] ids = new int[] {R.id.autorLivro, R.id.nomeLivro};

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(getApplicationContext(),
                R.layout.activity_query, cursor, nomeCampos, ids, 0);
        list.setAdapter(adapter);
    }
}
