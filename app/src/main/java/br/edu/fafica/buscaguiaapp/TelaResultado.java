package br.edu.fafica.buscaguiaapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class TelaResultado extends AppCompatActivity implements Runnable {

    private static int id_guia;
    private TextView txtNome;
    private TextView txtDesc;
    private ImageView img;
    //contato
    private TextView txtEmail;
    private TextView txtTel;
    private TextView txtCel;
    //endereco
    private TextView txtLogradouro;
    private TextView txtNumero;
    private TextView txtBairro;

    private Handler handler = new Handler();
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_resultado);

        img = (ImageView) findViewById(R.id.imgResul) ;

        txtNome = (TextView) findViewById(R.id.txtNomeResul);
        txtDesc = (TextView) findViewById(R.id.txtDescResul);

        txtEmail = (TextView) findViewById(R.id.txtEmailResul);
        txtTel = (TextView) findViewById(R.id.txtTelResul);
        txtCel = (TextView) findViewById(R.id.txtCelResul);

        txtLogradouro = (TextView) findViewById(R.id.txtLogradouroResul);
        txtNumero = (TextView) findViewById(R.id.txtNumeroResul);
        txtBairro = (TextView) findViewById(R.id.txtBairroResul);

        Intent it = getIntent();
        Bundle b = it.getExtras();
        id_guia = b.getInt("id_guia");


        dialog = new ProgressDialog(this);
        dialog.setMessage("Carregando Guia...");
        dialog.setTitle("BUSCA GUIA");
        dialog.show();

        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {

        Webservice ws = new Webservice();
        try{

            Guia guia = ws.guiaProcurarId(id_guia);

            img = (ImageView) findViewById(R.id.imgResul) ;

            txtNome.setText(guia.getNome());
            txtDesc.setText("Mais Informações: ".concat(guia.getDescricao()));

            txtEmail.setText("Email: ".concat(guia.getEmail()));
            txtTel.setText("Tel: ".concat(guia.getTelefone()));
            txtCel.setText("Cel: ".concat(guia.getCelular()));

            txtLogradouro.setText("Logradouro: ".concat(guia.getLogradouro()));
            txtNumero.setText("Nº: ".concat(guia.getNumero()));
            txtBairro.setText("Bairro: ".concat(guia.getBairro()));

            String URL = "http://192.168.1.123:9090/BuscaGuia/";

            Picasso.with(this).load(URL.concat(guia.getImagem())).into(img);



        }catch (Exception e){

        }finally {
            dialog.dismiss();
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
