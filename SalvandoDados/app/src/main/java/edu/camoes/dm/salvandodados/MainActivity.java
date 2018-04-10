package edu.camoes.dm.salvandodados;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnCache, btnInterno, btnExterno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCache = findViewById(R.id.btnCache);
        btnInterno = findViewById(R.id.btnInterno);
        btnExterno = findViewById(R.id.btnExterno);

        
    }
}
