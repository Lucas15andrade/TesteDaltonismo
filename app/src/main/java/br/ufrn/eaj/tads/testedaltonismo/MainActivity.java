package br.ufrn.eaj.tads.testedaltonismo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //int cont = 0;

    Boolean ver1 = false;
    Boolean ver2 = false;
    Boolean ver3 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Implementação utilizando o SharedPreferences
        SharedPreferences config = getSharedPreferences("config",MODE_PRIVATE);
        boolean salvar = config.getBoolean("salvar",false);
        String resposta1 = config.getString("r1","");
        String resposta2 = config.getString("r2","");
        String resposta3 = config.getString("r3","");

        if(salvar){
            TextView r1 = findViewById(R.id.resposta1);
            TextView r2 = findViewById(R.id.resposta2);
            TextView r3 = findViewById(R.id.resposta3);
            r1.setText(resposta1);
            r2.setText(resposta2);
            r3.setText(resposta3);
        }
        */

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

                if(ver1 == true && ver2 == true && ver3 == true){
                    resultadoFinal.setText("Você está bem!");
                }else{
                    resultadoFinal.setText("Você está mal!");
                }
                ver1 = false;
                ver2 = false;
                ver3 = false;

                TextView r1 = findViewById(R.id.resposta1);
                r1.setText("Resposta_1");

                TextView r2 = findViewById(R.id.resposta2);
                r2.setText("Resposta_2");

                TextView r3 = findViewById(R.id.resposta3);
                r3.setText("Resposta_3");
            }
        });
    }

    /*
    @Override
    protected void onStop() {
        super.onStop();

        CheckBox salvar = findViewById(R.id.checkSalvar);

        TextView r1 = findViewById(R.id.resposta1);
        TextView r2 = findViewById(R.id.resposta2);
        TextView r3 = findViewById(R.id.resposta3);

        if(salvar.isChecked()){
            SharedPreferences config = getSharedPreferences("config",MODE_PRIVATE);
            SharedPreferences.Editor editor = config.edit();

            editor.putBoolean("salvar", salvar.isChecked());
            editor.putString("r1",r1.getText().toString());
            editor.putString("r2",r2.getText().toString());
            editor.putString("r3",r3.getText().toString());

            editor.commit();
        }else{
            SharedPreferences config = getSharedPreferences("config",MODE_PRIVATE);
            SharedPreferences.Editor editor = config.edit();

            editor.remove("salvar");
            editor.remove("r1");
            editor.remove("r2");
            editor.remove("r3");

            editor.commit();
        }

    }
    */
    //Implementação utilizando o SaveInstance
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        TextView r1 = findViewById(R.id.resposta1);
        TextView r2 = findViewById(R.id.resposta2);
        TextView r3 = findViewById(R.id.resposta3);
        CheckBox salvar = findViewById(R.id.checkSalvar);

        outState.putString("resposta1",r1.getText().toString());
        outState.putString("resposta2",r2.getText().toString());
        outState.putString("resposta3",r3.getText().toString());
        outState.putBoolean("salvar", salvar.isChecked());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        String resposta1 = savedInstanceState.getString("resposta1");
        String resposta2 = savedInstanceState.getString("resposta2");
        String resposta3 = savedInstanceState.getString("resposta3");
        Boolean salvarVerifica = savedInstanceState.getBoolean("salvar");

        if(salvarVerifica){
            TextView r1 = findViewById(R.id.resposta1);
            TextView r2 = findViewById(R.id.resposta2);
            TextView r3 = findViewById(R.id.resposta3);
            CheckBox salvar = findViewById(R.id.checkSalvar);

            r1.setText(resposta1);
            r2.setText(resposta2);
            r3.setText(resposta3);

        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.i("valor","entrou no OnActivity");
        Log.i("valor","ResultCode: "+resultCode);

        if(data == null || resultCode == RESULT_CANCELED){
            Toast.makeText(this, "Erro ao restaurar", Toast.LENGTH_SHORT).show();
            return;
        }else{
            Bundle dados = data.getExtras();
            String valor = dados.getString("resultado");
            if(requestCode == 15){

                if(resultCode == RESULT_OK){
                    TextView tv = findViewById(R.id.resposta1);
                    tv.setText(valor);
                    if(valor.equals("2") ){
                        ver1 = true;
                    }
                }

            }else if(requestCode == 16){
                if(resultCode == RESULT_OK){
                    TextView tv = findViewById(R.id.resposta2);
                    tv.setText(valor);
                    if(valor.equals("29")){
                        ver2 = true;
                    }
                }


            }else if(requestCode == 17){
                if(resultCode == RESULT_OK){
                    TextView tv = findViewById(R.id.resposta3);
                    tv.setText(valor);
                    if(valor.equals("74")){
                        ver3 = true;
                    }
                }


            }
        }

        if(resultCode == 0){
            Log.i("valor","Result code é igual a ZERO");
        }

    }
}
