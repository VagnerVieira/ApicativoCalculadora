package br.udu.uniacademia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class JurosSimples extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juros_simples);




        Spinner tempo = (Spinner) findViewById(R.id.spnTempo);

        String[] itens = new String[]{"", "1", "2","3","4", "5","6","7", "8","9","10", "11","12"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, itens);
        tempo.setAdapter(adapter);

        Button calcular = findViewById(R.id.btCalcular);
        calcular.setOnClickListener(calcularJuros);

        FloatingActionButton voltarJC = findViewById(R.id.btVoltarJS);
        voltarJC.setOnClickListener(voltarClick);

    }

    private View.OnClickListener calcularJuros = new View.OnClickListener(){

        public void onClick(View v){

            Intent resultado = new Intent(JurosSimples.this, Resultado.class);

            EditText capital = (EditText) findViewById(R.id.edtCapital);
            Double valorCapital = Double.parseDouble(capital.getText().toString());
            EditText taxa = (EditText) findViewById(R.id.edtTaxa);
            Double valorTaxa = Double.parseDouble(taxa.getText().toString());
            Spinner tempo = (Spinner) findViewById(R.id.spnTempo);
            int valorTempo = Integer.parseInt( tempo.getSelectedItem().toString());

            if(!valorCapital.equals("") && !valorTaxa.equals("")){
            Double juros = valorCapital * (valorTaxa/100) * valorTempo;

            Bundle bundle = new Bundle();
            bundle.putDouble("juros", juros);
            resultado.putExtras(bundle);
            startActivity(resultado);
            finish();
            }

        }
    };

    private View.OnClickListener voltarClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent voltar = new Intent(JurosSimples.this, MainActivity.class);
            startActivity(voltar);
            finish();
        }
    };


}