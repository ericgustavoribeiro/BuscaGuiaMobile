package br.edu.fafica.buscaguiaapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class TelaBuscar extends AppCompatActivity implements Runnable {

    private List<Guia> guias;
    private GuiaAdapter adapter;
    private ListView listView;
    private Handler handler = new Handler();
    private ProgressDialog dialog;
    private static String nome;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_buscar);

        dialog = new ProgressDialog(this);
        dialog.setMessage("Carregando Guias...");
        dialog.setTitle("BUSCA GUIA");
        dialog.show();

        Intent it = getIntent();
        Bundle b = it.getExtras();
        nome = b.getString("nome");

        Log.i("Teste", nome);

        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {

        listView = (ListView) findViewById(R.id.listViewBusca);
        listView.setEmptyView(findViewById(android.R.id.empty));

        Webservice ws = new Webservice();
        final Intent it = new Intent(this, TelaResultado.class);
        int id;

        try{
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                    Guia guia = (Guia)adapterView.getItemAtPosition(position);
                    Toast.makeText(TelaBuscar.this, guia.getNome(), Toast.LENGTH_SHORT).show();
                    id = guia.getId_guia();
                    Bundle b = new Bundle();
                    b.putInt("id_guia", (int) id);
                    it.putExtras(b);
                    startActivity(it);
                    finish();
                }});

            guias = ws.guiaListarNome(nome);
            ArrayList<Guia> lista = new ArrayList<Guia>();
            for(Guia g : guias){
                Log.i("Teste", g.getNome());
                lista.add(g);
            }

            adapter = new GuiaAdapter(this, lista);
            listView.setAdapter(adapter);
        }catch (Exception e){

        }finally {
            dialog.dismiss();
        }
    }
}
