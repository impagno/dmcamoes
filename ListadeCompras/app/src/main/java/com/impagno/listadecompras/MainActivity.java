package com.impagno.listadecompras;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button botao;
    private EditText txtProduto;
    private ListView lstProdutos;

    private List<String> produtos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botao = findViewById(R.id.btnAdicionar);
        txtProduto = findViewById(R.id.txtProduto);
        lstProdutos = findViewById(R.id.lstProdutos);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!txtProduto.getText().toString().isEmpty()) {
                    produtos.add(txtProduto.getText().toString());
                    atualizaLista();
                    txtProduto.setText("");
                }

            }
        });

        lstProdutos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                produtos.remove(position);
                atualizaLista();
            }
        });
    }

    private void atualizaLista() {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, produtos);
        lstProdutos.setAdapter(adapter);
    }
}
