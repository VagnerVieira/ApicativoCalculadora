package br.udu.uniacademia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class DescontoSimples extends AppCompatActivity {
//d = N * i * n
//
//Na expressão para cálculo do desconto simples temos:
//d = valor do desconto
//N = valor nominal do título
//i = taxa de desconto
//n = tempo (antecipação do desconto)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desconto_simples);

        Spinner tempo = (Spinner) findViewById(R.id.spnTempoDS);
        String[] itens = new String[]{"", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, itens);
        tempo.setAdapter(adapter);

        Button calcularDS = findViewById(R.id.btDescontoSimples);
        calcularDS.setOnClickListener(calcularDescontoSimples);


      }

    private View.OnClickListener calcularDescontoSimples = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        Intent resultado = new Intent(DescontoSimples.this, Resultado.class);

        EditText Titulo = (EditText) findViewById(R.id.edtTaxaFixaJC);
        Double ValorTitulo = Double.parseDouble(Titulo.getText().toString());
        EditText taxaNominal = (EditText) findViewById(R.id.edtTaxaDesconto);
        Double valorTaxaDS = Double.parseDouble(taxaNominal.getText().toString());
        Spinner tempoDS = (Spinner) findViewById(R.id.spnTempoDS);
        int valorTempo = Integer.parseInt(tempoDS.getSelectedItem().toString());
            if (!ValorTitulo.equals("") && !valorTaxaDS.equals("")) {
                Double descontoSimples = ValorTitulo * valorTaxaDS * valorTempo;


                Bundle bundle = new Bundle();
                bundle.putDouble("juros", descontoSimples);
                resultado.putExtras(bundle);
                startActivity(resultado);
                finish();
            }

        }
    };

}