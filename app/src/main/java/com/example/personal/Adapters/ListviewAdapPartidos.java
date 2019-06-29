package com.example.personal.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.personal.R;
import com.example.personal.entidades.ListaPartidos;

import java.util.ArrayList;

public class ListviewAdapPartidos extends BaseAdapter {

    private Context context;
    private ArrayList<ListaPartidos> listaPartidos ;

    public ListviewAdapPartidos(Context context, ArrayList<ListaPartidos> listaPartidos) {
        this.context = context;
        this.listaPartidos = listaPartidos;
    }

    @Override
    public int getCount() {
        return listaPartidos.size();
    }

    @Override
    public Object getItem(int position) {
        return listaPartidos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ListaPartidos item = (ListaPartidos)getItem(position);

        convertView = LayoutInflater.from(context).inflate(R.layout.lista,null);
        ImageView imgfoto = convertView.findViewById(R.id.img_foto);
        TextView  fecha = convertView.findViewById(R.id.etxt_fecha_pL);
        TextView equipos = convertView.findViewById(R.id.etxt_equiposL);
        TextView tiempop = convertView.findViewById(R.id.etxt_tpartidoL);

        imgfoto.setImageResource(item.getFoto());
        fecha.setText(item.getFechaP());
        equipos.setText(item.getEquiposP());
        tiempop.setText(item.getTpartidoP());

        return  convertView;


    }
}
