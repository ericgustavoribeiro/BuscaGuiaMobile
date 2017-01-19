package br.edu.fafica.buscaguiaapp.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;

import br.edu.fafica.buscaguiaapp.R;
import br.edu.fafica.buscaguiaapp.fragments.GuiaFragment;
import br.edu.fafica.buscaguiaapp.fragments.PontoTuristicoFragment;

public class TabsAdapter extends FragmentStatePagerAdapter {

    private Context mContext;
    private String[] titles = {"GUIAS", "PONTO TURISTICO"};
    int[] icons = new int[]{
            R.drawable.ic_home_white_24dp,
            R.drawable.ic_map_white_24dp
    };
    private int heightIcon;

    public TabsAdapter(FragmentManager fm, Context context) {
        super(fm);

        mContext = context;
        double scale = context.getResources().getDisplayMetrics().density;
        heightIcon = (int)(24 * scale + 0.5f);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment frag = null;

        if(position == 0){
            frag = new GuiaFragment();
        } else if (position == 1){
            frag = new PontoTuristicoFragment();
        }

        Bundle b = new Bundle();
        b.putInt("position", position);

        frag.setArguments(b);
        return frag;
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        Drawable d = mContext.getResources().getDrawable(icons[position]);
        d.setBounds(0, 0, heightIcon, heightIcon);

        ImageSpan is = new ImageSpan(d);
        SpannableString sp = new SpannableString(" ");
        sp.setSpan(is, 0, sp.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return sp;
    }
}
