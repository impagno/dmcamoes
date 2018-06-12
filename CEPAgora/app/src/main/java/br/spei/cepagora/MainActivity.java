package br.spei.cepagora;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private Button botao;
    private TextView txtResultado;
    private EditText txtCEP;
    private ProgressDialog progress;
    Endereco endereco = new Endereco();
    private final int APP_CODIGO = 1234;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.INTERNET}, APP_CODIGO);
        }

        botao = (Button) findViewById(R.id.btnCEPId);
        txtResultado = (TextView) findViewById(R.id.textCEPId);
        txtCEP = (EditText) findViewById(R.id.txtCEPId);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progress = new ProgressDialog(MainActivity.this);
                progress.setTitle("Enviando...");
                progress.show();

                RetrofitService service = ServiceGenerator.createService(RetrofitService.class, txtCEP.getText().toString());
                Call<Endereco> call = service.consultaCEP();

                call.enqueue(new Callback<Endereco>() {
                    @Override
                    public void onResponse(Call<Endereco> call, Response<Endereco> response) {

                        if (response.isSuccessful()) {

                            Endereco respostaServidor = response.body();

                            //verifica aqui se o corpo da resposta não é nulo
                            if (respostaServidor != null) {
                                endereco.setLogradouro(respostaServidor.getLogradouro());
                                endereco.setBairro(respostaServidor.getBairro());
                                endereco.setCidade(respostaServidor.getCidade());
                                endereco.setUf(respostaServidor.getUf());
                                progress.dismiss();
                                txtResultado.setText(endereco.toString());

                            } else {
                                Toast.makeText(getApplicationContext(), "Resposta nula do servidor", Toast.LENGTH_SHORT).show();
                            }

                        } else {
                            Toast.makeText(getApplicationContext(), "Resposta não foi sucesso", Toast.LENGTH_SHORT).show();
                            // segura os erros de requisição
                            ResponseBody errorBody = response.errorBody();
                        }
                        progress.dismiss();
                    }

                    @Override
                    public void onFailure(Call<Endereco> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Erro na chamada ao servidor", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
