package com.example.ranchapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

public class mostrarEventos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_eventos);
        RecyclerView recyclerEventos = findViewById(R.id.recyclerEventos);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerEventos.setLayoutManager(manager);

        ArrayList<Evento> eventos = new ArrayList<>();

        eventos = (ArrayList<Evento>) getIntent().getSerializableExtra("eventos");
        Log.i("Eventos recibidos", eventos.toString());

        if(eventos == null) {
            Log.e("Error", "No se recibieron eventos");
            return;
        }

        EventoAdaptador adaptador = new EventoAdaptador(eventos);
        recyclerEventos.setAdapter(adaptador);

// Opcional: mejorar rendimiento
        recyclerEventos.setHasFixedSize(true);
    }
}