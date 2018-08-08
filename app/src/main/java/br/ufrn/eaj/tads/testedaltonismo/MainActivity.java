package br.ufrn.eaj.tads.testedaltonismo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int cont = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button botaoTeste1 = findViewById(R.id.botaoTeste1);
        botaoTeste1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),TesteActivity.class);
                intent.putExtra("valorImg", 1);

                startActivityForResult(intent, 15);
            }
        });

        Button botaoTeste2 = findViewById(R.id.botaoTeste2);
        botaoTeste2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TesteActivity.class);
                intent.putExtra("valorImg",02);
                startActivityForResult(intent,16);
            }
        });

        Button botaoTeste3 = findViewById(R.id.botaoTeste3);
        botaoTeste3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),TesteActivity.class);
                intent.putExtra("valorImg",03);
                startActivityForResult(intent,17);
            }
        });

        Button botaoVerificar = findViewById(R.id.botaoVerificar);
        botaoVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView resultadoFinal = findViewById(R.id.textResultado);

                if(cont == 3){
                    resultadoFinal.setText("Você está bem!");
                }else{
                    resultadoFinal.setText("Você está mal!");
                }
                cont = 0;
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.i("valor","entrou no OnActivity");
        Log.i("valor","ResultCode: "+resultCode);
        Bundle dados = data.getExtras();
        if(dados != null){
            String valor = dados.getString("resultado");
            if(requestCode == 15){
                TextView tv = findViewById(R.id.resposta1);
                tv.setText(valor);
                if(valor.equals("2") ){
                    cont++;
                }
            }else if(requestCode == 16){
                TextView tv = findViewById(R.id.resposta2);
                tv.setText(valor);
                if(valor.equals("29")){
                    cont++;
                }
            }else if(requestCode == 17){
                TextView tv = findViewById(R.id.resposta3);
                tv.setText(valor);
                if(valor.equals("74")){
                    cont++;
                }
            }
        }


    }
}
