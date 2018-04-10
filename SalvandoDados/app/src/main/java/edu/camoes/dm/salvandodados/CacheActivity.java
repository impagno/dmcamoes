package edu.camoes.dm.salvandodados;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CacheActivity extends AppCompatActivity {

    private Button btnSalvar, btnLer;
    private EditText txtSalvar, txtLer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cache);

        btnSalvar = findViewById(R.id.btnSalvarInterno);
        btnLer = findViewById(R.id.btnLer);
        txtSalvar = findViewById(R.id.txtSalvar);
        txtLer = findViewById(R.id.txtLer);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    File file = File.createTempFile("arquivo_temp", null, getBaseContext().getCacheDir());
                    FileOutputStream out = new FileOutputStream(file);
                    out.write(txtSalvar.getText().toString().getBytes());
                    out.close();
                } catch (IOException e) {
                    // Error while creating file
                    Toast.makeText(getBaseContext(), "Erro: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnLer.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View v) {
                try {
                    File file = File.createTempFile("arquivo_temp", null, getBaseContext().getCacheDir());
                    byte[] buffer = new byte[(int)file.length()];
                    FileInputStream in = new FileInputStream(file);
                    in.read(buffer);
                    in.close();
                    txtLer.setText(buffer.toString());
                } catch (IOException e) {
                    Toast.makeText(getBaseContext(), "Erro: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
