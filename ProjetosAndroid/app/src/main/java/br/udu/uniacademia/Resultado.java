package br.udu.uniacademia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Resultado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        Button voltar = findViewById(R.id.btVoltar);
        TextView resultado = findViewById(R.id.valorFinal);

        Intent atual = getIntent();
        Bundle bundle = atual.getExtras();
        Double juros = bundle.getDouble("juros");
        resultado.setText(juros.toString());


        voltar.setOnClickListener(voltarClick);


    }

    private View.OnClickListener voltarClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent voltar = new Intent(Resultado.this, MainActivity.class);
            startActivity(voltar);
            finish();
        }
    };
}