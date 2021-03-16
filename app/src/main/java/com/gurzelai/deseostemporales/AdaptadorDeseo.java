package com.gurzelai.deseostemporales;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorDeseo extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<Deseo> deseos;

    public AdaptadorDeseo(Context context, int layout, ArrayList<Deseo> deseos) {
        this.context = context;
        this.layout = layout;
        this.deseos = deseos;
    }


    @Override
    public int getCount() {
        return this.deseos.size();
    }

    @Override
    public Object getItem(int position) {
        return this.deseos.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        // Copiamos la vista
        View v = convertView;

        //Inflamos la vista con nuestro propio layout
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);

        v = layoutInflater.inflate(R.layout.activity_adaptador_deseo, null);
        // Valor actual según la posición

        String nombre = deseos.get(position).getNombre();

        // Referenciamos el elemento a modificar y lo rellenamos
        TextView tvNombre = (TextView) v.findViewById(R.id.tvNombre);
        tvNombre.setText(nombre);
        TextView tvDia = (TextView) v.findViewById(R.id.tvDiaAviso);
        tvDia.setText(deseos.get(position).getDiaAviso());
        //Devolvemos la vista inflada
        return v;
    }
}
