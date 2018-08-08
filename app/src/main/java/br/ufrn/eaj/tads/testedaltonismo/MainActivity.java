package br.ufrn.eaj.tads.testedaltonismo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

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

                startActivityForResult(intent, 01);
            }
        });

        Button botaoTeste2 = findViewById(R.id.botaoTeste2);
        botaoTeste2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TesteActivity.class);
                intent.putExtra("valorImg",02);
                startActivityForResult(intent,01);
            }
        });

        Button botaoTeste3 = findViewById(R.id.botaoTeste3);
        botaoTeste3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),TesteActivity.class);
                intent.putExtra("valorImg",03);
                startActivityForResult(intent,01);
            }
        });

        Button botaoVerificar = findViewById(R.id.botaoVerificar);
        botaoVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Falta implementação
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        //É o código padrão que foi passado
        if(requestCode == 01){

        }
    }
}
