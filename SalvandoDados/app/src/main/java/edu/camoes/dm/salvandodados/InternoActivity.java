package edu.camoes.dm.salvandodados;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class InternoActivity extends AppCompatActivity {

    private EditText txtSavar, txtLer;
    private Button btnSalvar, btnLer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interno);

        txtSavar = findViewById(R.id.txtOut);
        txtLer  = findViewById(R.id.txtInput);
        btnLer = findViewById(R.id.btnLerInterno);
        btnSalvar = findViewById(R.id.btnSalvarInterno);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FileOutputStream outputStream;

                try {
                    outputStream = openFileOutput("arquivo_interno.txt", Context.MODE_PRIVATE);
                    outputStream.write(txtSavar.getText().toString().getBytes());
                    outputStream.close();
                    Toast.makeText(getBaseContext(), "Arquivo salvo.", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(getBaseContext(), "Erro: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnLer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FileInputStream in;
                File file;

                try {
                    file = new File("arquivo_interno.txt");
                    byte[] buffer = new byte[(int)file.length()];
                    in = openFileInput("arquivo_interno.txt");
                    in.read(buffer);
                    in.close();

                    txtLer.setText(buffer.toString());
                } catch (Exception e) {
                    Toast.makeText(getBaseContext(), "Erro: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
