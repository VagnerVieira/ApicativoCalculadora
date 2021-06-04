package br.udu.uniacademia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ButtonBarLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

//d = N * i * n
//Na expressão para cálculo do desconto simples temos:
//d = valor do desconto
//N = valor nominal do título
//i = taxa de desconto
//n = tempo (antecipação do desconto)
public class DescontoSimples extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desconto_simples);

        Spinner tempo = (Spinner) findViewById(R.id.spnTempoDS);
        String[] itens = new String[]{"", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, itens);
        tempo.setAdapter(adapter);

        Button calcularDS = findViewById(R.id.btCalcularDS);
        calcularDS.setOnClickListener(calcularDescontoSimples);

        FloatingActionButton voltarDS = findViewById(R.id.btVoltarTeste);
        voltarDS.setOnClickListener(voltarClick);
      }

    private View.OnClickListener calcularDescontoSimples = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        Intent resultado = new Intent(DescontoSimples.this, Resultado.class);

        EditText valor = (EditText) findViewById(R.id.edtDesconto);
        Double valorNominal = Double.parseDouble(valor.getText().toString());
        EditText desconto = (EditText) findViewById(R.id.edtTaxaDesconto);
        Double valortaxaDesconto = Double.parseDouble(desconto.getText().toString());
        Spinner tempo = (Spinner) findViewById(R.id.spnTempoDS);
        int valorTempo = Integer.parseInt(tempo.getSelectedItem().toString());


            if (!valorNominal.equals(" ") && !valortaxaDesconto.equals("")) {
                Double descontoSimples = valorNominal * valortaxaDesconto * valorTempo;


                Bundle bundle = new Bundle();
                bundle.putDouble("juros", descontoSimples);
                resultado.putExtras(bundle);
                startActivity(resultado);
                finish();
            }

        }
    };

    private View.OnClickListener voltarClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent voltar = new Intent(DescontoSimples.this, MainActivity.class);
            startActivity(voltar);
            finish();
        }
    };

}