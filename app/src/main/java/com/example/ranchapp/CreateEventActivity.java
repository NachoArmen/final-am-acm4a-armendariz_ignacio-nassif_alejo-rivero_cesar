package com.example.ranchapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CreateEventActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);
    }

    public void create_event(View view){
        //traigo los ui para crear el evento
        EditText textTitle = findViewById(R.id.editTextTitle);
        EditText textLocation = findViewById(R.id.editTextLocation);
        EditText textDescripcion = findViewById(R.id.editTextDescripcion);
        EditText textFecha = findViewById(R.id.editTextDate);

        String titulo = textTitle.getText().toString();
        String lugar = textLocation.getText().toString();
        String descripcion = textDescripcion.getText().toString();

        String fechaString = textFecha.getText().toString();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");

        Date fecha = null;
        try {
            fecha = formatoFecha.parse(fechaString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //creo el evento como objeto
        Evento evento = new Evento(titulo,fecha,lugar,descripcion);
        ArrayList<Evento> listaEventos = new ArrayList<Evento>();
        listaEventos.add(evento);
        Log.i("Eventos", listaEventos.toString());


        //le meto un toast que diga evento creado- para el final-

        Intent intent = new Intent(this, WelcomeActivity.class);
        intent.putExtra("eventos", listaEventos);
        startActivity(intent);




    }
}