package com.example.ranchapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class mostrarEventos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_eventos);
        ArrayList<Evento> eventos = (ArrayList<Evento>) getIntent().getSerializableExtra("eventos");

        for(Evento evento : eventos) {
            // Mostrar en un TextView por ejemplo
            TextView textView = findViewById(R.id.textView);
            textView.setText(evento.getTitulo());

            // Otra forma es mostrarlos en un RecyclerView
            // https://developer.android.com/guide/topics/ui/layout/recyclerview
        }
    }


}