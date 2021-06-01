package br.udu.uniacademia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

//M = C (1+i)t
//M: montante
//C: capital
//i: taxa fixa
//t: período de tempo
public class JurosComposto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juros_composto);

        Spinner tempo = (Spinner) findViewById(R.id.spnTempoJC);
        String[] itens = new String[]{"", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, itens);
        tempo.setAdapter(adapter);

        Button calcularJC = findViewById(R.id.btCalcularJC);
        calcularJC.setOnClickListener(calcularJurosComposto);
    }

    private View.OnClickListener calcularJurosComposto = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent resultado = new Intent(JurosComposto.this, Resultado.class);

            EditText capital = (EditText) findViewById(R.id.edtCapitalJC);
            Double valorCapitalJC = Double.parseDouble(capital.getText().toString());
            EditText taxa = (EditText) findViewById(R.id.edtTaxaFixaJC);
            Double valorTaxaJC = Double.parseDouble(taxa.getText().toString());
            Spinner tempo = (Spinner) findViewById(R.id.spnTempoJC);
            int valorTempo = Integer.parseInt(tempo.getSelectedItem().toString());

            if (!valorCapitalJC.equals("") && !valorTaxaJC.equals("")) {
                Double jurosCompostos = valorCapitalJC * Math.pow((1 + valorTaxaJC), valorTempo);


                Bundle bundle = new Bundle();
                bundle.putDouble("juros", jurosCompostos);
                resultado.putExtras(bundle);
                startActivity(resultado);
                finish();
            }
        }
    };
}