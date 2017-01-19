package br.edu.fafica.buscaguiaapp;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class TelaResultadoPonto extends AppCompatActivity {

    private TextView txtNome;
    private TextView txtDesc;
    private ImageView img;
    private String nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_resultado_ponto);
        img = (ImageView) findViewById(R.id.imgPontoResul) ;
        txtNome = (TextView) findViewById(R.id.txtNomePontoResul);
        txtDesc = (TextView) findViewById(R.id.txtDescPontoResul);

        Intent it = getIntent();
        Bundle b = it.getExtras();
        int img_ponto = b.getInt("img_ponto");
        String nome = b.getString("nome_ponto");
        String desc = b.getString("desc_ponto");


        PontoTuristico pontoTuristico = new PontoTuristico(nome, desc, img_ponto);
        Resources res = this.getResources();
        TypedArray logos = res.obtainTypedArray(R.array.logos);

        img.setImageDrawable(logos.getDrawable(pontoTuristico.getImg()));
        txtNome.setText(nome);
        txtDesc.setText(desc);
        }
}
