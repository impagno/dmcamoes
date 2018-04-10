package edu.camoes.dm.salvandodados;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ExternoActivity extends AppCompatActivity {

    private EditText txtSavar, txtLer;
    private Button btnSalvar, btnLer;

    private final int RESPONSE_REQUEST_READ_EXTERNAL = 1;
    private final int RESPONSE_REQUEST_WRITE_EXTERNAL = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_externo);

        // Obtem a permissão para ler da fonte externa de dados
        if (ContextCompat.checkSelfPermission(getBaseContext(),
                Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,
                new String[]{ Manifest.permission.READ_EXTERNAL_STORAGE },
                    RESPONSE_REQUEST_READ_EXTERNAL);
        }

        // Obtem a permissão para escrever na fonte externa de dados
        if (ContextCompat.checkSelfPermission(getBaseContext(),
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,
                    new String[]{ Manifest.permission.WRITE_EXTERNAL_STORAGE },
                    RESPONSE_REQUEST_WRITE_EXTERNAL);
        }

        // Verifica o status do SD
        String state = Environment.getExternalStorageState();
        if (!Environment.MEDIA_MOUNTED.equals(state)) {
            Toast.makeText(getBaseContext(), "Cartão SD não está disponível", Toast.LENGTH_SHORT).show();
            return;
        }

        txtSavar = findViewById(R.id.txtLerExterno);
        txtLer  = findViewById(R.id.txtSavarExterno);
        btnLer = findViewById(R.id.btnLerExterno);
        btnSalvar = findViewById(R.id.btnSalvarExterno);

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

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case RESPONSE_REQUEST_READ_EXTERNAL: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    btnLer = findViewById(R.id.btnLerExterno);
                    btnLer.setEnabled(true);
                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }
            case RESPONSE_REQUEST_WRITE_EXTERNAL: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    btnSalvar = findViewById(R.id.btnSalvarExterno);
                    btnSalvar.setEnabled(true);
                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }
        }
    }
}

