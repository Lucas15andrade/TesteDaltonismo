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

public class TesteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teste);

        Bundle params = getIntent().getExtras();
        int valor = params.getInt("valorImg");
        Log.i("valor","valor: "+valor);

        //String caminho = "/res/drawable/teste"+valor;

        ImageView iv = findViewById(R.id.imgTeste);
        EditText texto = findViewById(R.id.campoValor);
        String n = texto.getText().toString();
        int n1 = Integer.parseInt(n);

        //iv.setImage

        if(valor == 1){
            iv.setImageResource(R.drawable.teste1);

            Intent intent = new Intent();
            Bundle data = new Bundle();

            data.putInt("img1",n1);
            intent.putExtras(data);
            setResult(15);
        }else if(valor == 2){
            iv.setImageResource(R.drawable.teste2);

            Intent intent = new Intent();
            Bundle data = new Bundle();

            data.putInt("img2",n1);
            intent.putExtras(data);
            setResult(16);
        }else if(valor == 3){
            iv.setImageResource(R.drawable.teste3);

            Intent intent = new Intent();
            Bundle data = new Bundle();

            data.putInt("img2",n1);
            intent.putExtras(data);
            setResult(17);
        }

        Button botaoOk = findViewById(R.id.botaoOk);
        botaoOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });
    }
}
