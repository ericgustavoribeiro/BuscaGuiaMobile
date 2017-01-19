package br.edu.fafica.buscaguiaapp.fragments;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.edu.fafica.buscaguiaapp.PontoAdapter;
import br.edu.fafica.buscaguiaapp.PontoTuristico;
import br.edu.fafica.buscaguiaapp.R;
import br.edu.fafica.buscaguiaapp.TelaResultado;
import br.edu.fafica.buscaguiaapp.TelaResultadoPonto;

public class PontoTuristicoFragment extends Fragment {

    List<PontoTuristico> pontos;
    PontoAdapter adapter;
    ListView listView;

    public PontoTuristicoFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_guia, container, false);

        //listView = new ListView(getActivity());

        //se nao pega comenta
        listView = (ListView) getActivity().findViewById(R.id.listViewPontos);

        //se o outro nao pegar descomenta esse e comenta o de cima
        //listView = (ListView) view.findViewById(R.id.listViewPontos);


        final Intent it = new Intent(getActivity(), TelaResultadoPonto.class);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                PontoTuristico pontoTuristico = (PontoTuristico)adapterView.getItemAtPosition(position);
                Toast.makeText(getActivity(), pontoTuristico.getNome(), Toast.LENGTH_SHORT).show();
                Bundle b = new Bundle();

                b.putInt("img_ponto", (int) pontoTuristico.getImg());
                b.putString("nome_ponto", pontoTuristico.getNome());
                b.putString("desc_ponto", pontoTuristico.getDescricao());
                it.putExtras(b);
                startActivity(it);
            }});


        pontos = new ArrayList<PontoTuristico>();
        pontos.add(new PontoTuristico("Feira de Caruaru", "kjkhhkkjkhkh", 0));
        pontos.add(new PontoTuristico("Alto do Moura", "kjkhhkkjkhkh", 0));
        pontos.add(new PontoTuristico("Museu XXX", "kjkhhkkjkhkh", 0));

        adapter = new PontoAdapter(getActivity().getBaseContext(), pontos);
        listView.setAdapter(adapter);

        return view;
    }
}
