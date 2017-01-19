package br.edu.fafica.buscaguiaapp;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Eric Gustavo on 04/12/2016.
 */

public class PontoAdapter extends BaseAdapter {

    Context context;
    List<PontoTuristico> pontos;

    public PontoAdapter(Context context, List<PontoTuristico> pontos){
        this.context = context;
        this.pontos = pontos;
    }

    @Override
    public int getCount() {
        return pontos.size();
    }

    @Override
    public Object getItem(int position) {
        return pontos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       PontoTuristico ponto = pontos.get(position);
       ViewHolder holder = null;

        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_ponto, null);
            holder = new ViewHolder();
            holder.imgPonto = (ImageView) convertView.findViewById(R.id.imgPonto);
            holder.txtNomePonto = (TextView) convertView.findViewById(R.id.txtNomePonto);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)convertView.getTag();
        }

        Resources res = context.getResources();
        TypedArray logos = res.obtainTypedArray(R.array.logos);
        //se liga a variavel img é int ai oq tu vai vazer no array q ta em ...res/values/array
        //só tem um mais ai tu coloca mais imagem ai ele funciona como um array normal a posicao 0
        //vai ser a primeira coisa do teu array, no caso tipo se a imagem do alto do moura tiver na posicao
        //4 no array ela vai ser a 3, ai na variavel img(int) tu vai colocar 3
        holder.imgPonto.setImageDrawable(logos.getDrawable(ponto.getImg()));
        holder.txtNomePonto.setText(ponto.getNome());

        return convertView;
    }

    static class ViewHolder{
        ImageView imgPonto;
        TextView txtNomePonto;
    }
}
