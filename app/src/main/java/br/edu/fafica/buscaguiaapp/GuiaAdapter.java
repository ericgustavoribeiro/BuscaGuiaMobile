package br.edu.fafica.buscaguiaapp;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Eric Gustavo on 03/12/2016.
 */

public class GuiaAdapter extends BaseAdapter {

    Context context;
    List<Guia> guias;
    private static String URL;

    public GuiaAdapter(Context context, List<Guia> guias){
        this.context = context;
        this.guias = guias;
    }

    @Override
    public int getCount() {
        return guias.size();
    }

    @Override
    public Object getItem(int position) {
        return guias.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Guia guia = guias.get(position);

        ViewHolder holder = null;
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_guia, null);
            holder = new ViewHolder();
            holder.imgGuia =(ImageView) convertView.findViewById(R.id.imgGuia);
            holder.txtNomeGuia = (TextView) convertView.findViewById(R.id.txtNomeGuia);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)convertView.getTag();
        }

        URL = "http://192.168.1.123:9090/BuscaGuia/";
        Resources res = context.getResources();
        Picasso.with(context).load(URL.concat(guia.getImagem())).into(holder.imgGuia);
        holder.txtNomeGuia.setText(guia.getNome());

        return convertView;
    }

    static class ViewHolder{
        ImageView imgGuia;
        TextView txtNomeGuia;

    }

}
