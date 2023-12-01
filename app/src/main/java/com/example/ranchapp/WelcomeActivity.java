package com.example.ranchapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class WelcomeActivity extends AppCompatActivity {
    ArrayList<Evento> eventos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        eventos = (ArrayList<Evento>) getIntent().getSerializableExtra("eventos");
        //hacer los checkbox o la lista de los eventos y un boton de crear, al darle crear te debe mostrar los enventos creados
    }

    public void create_event(View view){
        Intent intent = new Intent(this, CreateEventActivity.class);
        startActivity(intent);
    }
    public void show_event(View view){
        Intent intent = new Intent(this, mostrarEventos.class);
        intent.putExtra("eventos", eventos);
        startActivity(intent);

    }
    public void logOut(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}