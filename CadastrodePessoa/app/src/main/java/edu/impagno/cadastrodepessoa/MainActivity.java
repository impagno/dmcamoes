package edu.impagno.cadastrodepessoa;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements PessoaFisica.OnFragmentInteractionListener, PessoaJuridica.OnFragmentInteractionListener {

    private RadioGroup radio;
    private int flagPessoa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radio = findViewById(R.id.radioGroup);

        // mostra o fragmento default
        switch(radio.getCheckedRadioButtonId()) {
            case R.id.rbPF:
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.frmLayout, new PessoaFisica()).commit();
            break;
            case R.id.rbPJ:
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.frmLayout, new PessoaJuridica()).commit();
            break;
        }

        radio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId) {
                    case R.id.rbPF:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.frmLayout, new PessoaFisica()).commit();
                        break;
                    case R.id.rbPJ:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.frmLayout, new PessoaJuridica()).commit();
                        break;
                }
            }
        });
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
