package com.example.ranchapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

public class WelcomeActivity extends AppCompatActivity {
    ArrayList<Evento> eventos;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        this.mAuth = FirebaseAuth.getInstance();
        eventos = (ArrayList<Evento>) getIntent().getSerializableExtra("eventos");
        //hacer los checkbox o la lista de los eventos y un boton de crear, al darle crear te debe mostrar los enventos creados


    }


    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = this.mAuth.getCurrentUser();
        TextView msg = findViewById(R.id.msgBienvenida);
        msg.setText("Ha ingresado con " + currentUser.getEmail());

    }

    @Override
    protected void onResume() {

        super.onResume();

        eventos = (ArrayList<Evento>) getIntent().getSerializableExtra("eventos");

    }
    public void create_event(View view){
        Intent intent = new Intent(this, CreateEventActivity.class);
        startActivity(intent);
    }
    public void show_event(View view){
        if (eventos != null){
            Intent intent = new Intent(this, mostrarEventos.class);
            intent.putExtra("eventos", eventos);
            startActivity(intent);
        }else{
            Toast.makeText(WelcomeActivity.this, "No hay eventos disponibles", Toast.LENGTH_SHORT).show();
        }


    }
    public void logOut(View view){
        this.mAuth.signOut();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

}