package br.udu.uniacademia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button jurosSimples = findViewById(R.id.btJurosSimples);
        jurosSimples.setOnClickListener(clickJurosSimples);

        Button jurosComposto = findViewById(R.id.btJurosComposto);
        jurosComposto.setOnClickListener(clickJurosComposto);

        Button descontoSimples = findViewById(R.id.btDescontoSimples);
        descontoSimples.setOnClickListener(clickDescontoSimples);
    }

    private View.OnClickListener clickJurosSimples = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent viewJurosSimples = new Intent(MainActivity.this, JurosSimples.class);
            startActivity(viewJurosSimples);
            finish();
        }
    };

    private View.OnClickListener clickJurosComposto = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent viewJurosComposto = new Intent(MainActivity.this, JurosComposto.class);
            startActivity(viewJurosComposto);
            finish();
        }
    };

    private View.OnClickListener clickDescontoSimples = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent viewDescontoSimples = new Intent(MainActivity.this, DescontoSimples.class);
            startActivity(viewDescontoSimples);
            finish();
        }
    };

}