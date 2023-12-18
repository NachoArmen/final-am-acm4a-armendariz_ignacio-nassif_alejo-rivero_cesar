package com.example.ranchapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class WelcomeActivity extends AppCompatActivity {
    ArrayList<Evento> eventos;
    private FirebaseAuth mAuth;

    private FirebaseFirestore db =FirebaseFirestore.getInstance();

    private TextView nombre;
    private TextView apellido;
    private TextView validado;

    private static final int CREATE_EVENT_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        this.mAuth = FirebaseAuth.getInstance();

        if (eventos == null) {
            eventos = new ArrayList<>(); // Inicializa la lista solo si es null
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = this.mAuth.getCurrentUser();
        TextView msg = findViewById(R.id.msgBienvenida);
        msg.setText("Ha ingresado con " + currentUser.getEmail());

        if (currentUser != null) {
            userData();
        }

    }



    @Override
    protected void onResume() {
        super.onResume();

        ArrayList<Evento> eventosActualizados = (ArrayList<Evento>) getIntent().getSerializableExtra("eventos");
        if (eventosActualizados != null) {
            eventos = eventosActualizados;
            Log.i("WelcomeActivity", "Lista de eventos actualizada: " + eventos.toString());
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CREATE_EVENT_REQUEST_CODE && resultCode == RESULT_OK) {
            // Recibe el nuevo evento y agrégalo a la lista
            Evento evento = (Evento) data.getSerializableExtra("evento");
            if (evento != null) {
                if (eventos == null) {
                    eventos = new ArrayList<>(); // Inicializa la lista solo si es null
                }
                eventos.add(evento);
                Log.i("WelcomeActivity", "Evento agregado a la lista: " + evento.toString());
            } else {
                Log.e("WelcomeActivity", "El objeto 'evento' es null");
            }
        }
    }
    public void create_event(View view){
        Intent intent = new Intent(this, CreateEventActivity.class);
        startActivityForResult(intent, CREATE_EVENT_REQUEST_CODE);

    }
    public void show_event(View view){
        if (eventos != null && eventos.size()>=1){
            Intent intent = new Intent(this, mostrarEventos.class);
            intent.putExtra("eventos", eventos);
            startActivity(intent);
        } else {
            Toast.makeText(WelcomeActivity.this, "No hay eventos disponibles", Toast.LENGTH_SHORT).show();
        }


    }
    public void logOut(View view){
        this.mAuth.signOut();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }



    private void userData() {
        DocumentReference docRef = db.collection("users").document("u1");
        docRef.get().addOnCompleteListener(task -> {
            if (task.isSuccessful()){
                DocumentSnapshot document = task.getResult();
                if (document.exists()){
                    String lastname = document.getString("lastname");
                    String name = document.getString("name");
                    String validated = String.valueOf(document.getBoolean("validated"));

                    nombre =  findViewById(R.id.tvNameFB);
                    nombre.setText(name);

                    apellido = findViewById(R.id.tvLastNameFB);
                    apellido.setText(lastname);

                    validado = findViewById(R.id.tvValidatedFB);
                    validado.setText(validated);



                }
            }
        });
    }






}