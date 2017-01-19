package br.edu.fafica.buscaguiaapp.fragments;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.edu.fafica.buscaguiaapp.Guia;
import br.edu.fafica.buscaguiaapp.GuiaAdapter;
import br.edu.fafica.buscaguiaapp.R;
import br.edu.fafica.buscaguiaapp.TelaResultado;
import br.edu.fafica.buscaguiaapp.Webservice;

public class GuiaFragment extends Fragment implements Runnable {

    private List<Guia> guias;
    private GuiaAdapter adapter;
    private ListView listView;
    private Handler handler = new Handler();
    private ProgressDialog dialog;

    protected RecyclerView mRecycleView;

    public GuiaFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_guia, container, false);

//        mRecycleView = (RecyclerView) view.findViewById(R.id.rv_listaTuristico);
//        mRecycleView.setHasFixedSize(true);
//        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
//        llm.setOrientation(LinearLayoutManager.VERTICAL);
//        mRecycleView.setLayoutManager(llm);

        dialog = new ProgressDialog(getActivity());
        dialog.setMessage("Carregando Guias...");
        dialog.setTitle("BUSCA GUIA");
        dialog.show();

        Thread t = new Thread(this);
        t.start();

        return view;
    }

    @Override
    public void run() {
     listView = (ListView) getView().findViewById(R.id.listViewGuias);
     listView.setEmptyView(getView().findViewById(android.R.id.empty));

        Webservice ws = new Webservice();
        final Intent it = new Intent(getActivity(), TelaResultado.class);
        int id;

        try{
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                    Guia guia = (Guia)adapterView.getItemAtPosition(position);
                    Toast.makeText(getActivity(), guia.getNome(), Toast.LENGTH_SHORT).show();
                    id = guia.getId_guia();
                    Bundle b = new Bundle();
                    b.putInt("id_guia", (int) id);
                    it.putExtras(b);
                    startActivity(it);
                }});

            guias = ws.guiaListar();

            ArrayList<Guia> lista = new ArrayList<Guia>();

            for(Guia g : guias){
                lista.add(g);
            }

            adapter = new GuiaAdapter(getActivity(), lista);
            listView.setAdapter(adapter);

        }catch (Exception e){

        }finally {
           // dialog.dismiss();

        }
    }


    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onStop() {
        super.onStop();
    }
}
