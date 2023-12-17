package com.example.ranchapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

public class mostrarEventos extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_eventos);
        mAuth = FirebaseAuth.getInstance();
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

    public void salir(View view){
        Intent intent = new Intent(this, WelcomeActivity.class);
        startActivity(intent);


    }

}