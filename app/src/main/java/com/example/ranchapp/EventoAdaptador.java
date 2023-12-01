package com.example.ranchapp;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class EventoAdaptador extends RecyclerView.Adapter<EventoAdaptador.ViewHolder> {

    ArrayList<Evento> listaEventos;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public EventoAdaptador(ArrayList<Evento> eventos) {
        this.listaEventos = eventos;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_evento, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
       Evento eventoActual = listaEventos.get(position);

        holder.txtTitulo.setText(eventoActual.getTitulo());
        holder.txtLugar.setText(eventoActual.getLugar());
        holder.txtDescripcion.setText(eventoActual.getDescripcion());
        String fecha = sdf.format(eventoActual.getFecha());

        holder.txtFecha.setText(fecha);       // holder.txtTitulo.setText("Evento de prueba");
    }

    @Override
    public int getItemCount() {
        return listaEventos.size();
       // int size = listaEventos.size();

       // Log.i("Tamaño", "Lista tiene " + size + " elementos");

       // return size;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView txtTitulo;
        public TextView txtFecha;
        public TextView txtLugar;
        public TextView txtDescripcion;

        public ViewHolder(View itemView) {
            super(itemView);
            txtTitulo = itemView.findViewById(R.id.txtTitulo);
            txtFecha = itemView.findViewById(R.id.txtFecha);
            txtLugar = itemView.findViewById(R.id.txtLugar);
            txtDescripcion = itemView.findViewById(R.id.txtDescripcion);


        }

    }

}