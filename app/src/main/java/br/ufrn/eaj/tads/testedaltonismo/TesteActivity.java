package br.ufrn.eaj.tads.testedaltonismo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class TesteActivity extends AppCompatActivity {
    int valor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teste);

        Bundle params = getIntent().getExtras();
        valor = params.getInt("valorImg");
        Log.i("valor","valor: "+valor);


        ImageView iv = findViewById(R.id.imgTeste);

        if(valor == 1){
            iv.setImageResource(R.drawable.teste1);


        }else if(valor == 2){
            iv.setImageResource(R.drawable.teste2);


        }else if(valor == 3){
            iv.setImageResource(R.drawable.teste3);

        }

        Button botaoOk = findViewById(R.id.botaoOk);
        botaoOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText texto = findViewById(R.id.campoValor);
                String n = texto.getText().toString();
                if(n.equals("")){
                    Toast.makeText(TesteActivity.this, "Campo vazio", Toast.LENGTH_SHORT).show();
                } else{
                    Intent intent = new Intent();
                    Bundle data = new Bundle();

                    data.putString("resultado",n);
                    intent.putExtras(data);

                    setResult(RESULT_OK,intent);

                    finish();
                }


            }
        });

        Button botaoCancelar = findViewById(R.id.botaoCancelar);
        botaoCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("valor","Entrou no botão cancelar");
                Intent intent = new Intent();
                setResult(RESULT_CANCELED,intent);
                finish();
            }
        });

    }
}
