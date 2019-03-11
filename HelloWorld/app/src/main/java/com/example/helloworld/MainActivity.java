package com.example.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private EditText text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.editText);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),
                        "Ola " + text.getText().toString(),
                        Toast.LENGTH_LONG).show();

                Bundle bundle = new Bundle();
                bundle.putString("nome", text.getText().toString());

                Intent intent = new Intent(getApplicationContext(),
                        SecondActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}
