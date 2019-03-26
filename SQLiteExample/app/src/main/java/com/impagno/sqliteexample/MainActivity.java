package com.impagno.sqliteexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.impagno.sqliteexample.controller.DatabaseController;

public class MainActivity extends AppCompatActivity {

    private EditText txtTitulo;
    private EditText txtAutor;
    private EditText txtEditora;
    private Button btnCadastrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTitulo = findViewById(R.id.txtTitulo);
        txtAutor = findViewById(R.id.txtAutor);
        txtEditora = findViewById(R.id.txtEditora);

        btnCadastrar = findViewById(R.id.button);
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseController crud = new DatabaseController(getApplicationContext());

                String strTitulo = txtTitulo.getText().toString();
                String strAutor = txtAutor.getText().toString();
                String strEditora = txtEditora.getText().toString();
                String strResultado = crud.insert(strTitulo, strAutor, strEditora);

                Toast.makeText(getApplicationContext(), strResultado, Toast.LENGTH_LONG).show();
            }
        });
    }
}
