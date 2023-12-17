package com.example.ranchapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class WelcomeActivity extends AppCompatActivity {
    ArrayList<Evento> eventos;
    private FirebaseAuth mAuth;
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
        // Definimos url de la imagen
        String imageUrl = "https://www.telam.com.ar/thumbs/bluesteel/advf/imagenes/2020/06/5ed4e9b33f900_450.jpg";

        // Creamos imageView para mostrar imagen
        ImageView imageView = findViewById(R.id.imageView);

        // Creamos metodo para cargar la imagen en segundo plano
        private void loadImage() {


            URLConnection connection = new URL(imageUrl).openConnection();


            connection.setConnectTimeout(3000);
            connection.setReadTimeout(3000);


            byte[] imageData = new byte[connection.getContentLength()];
            try {
                connection.getInputStream().read(imageData);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            // Convertimos imagen a bitmap
            Bitmap bitmap = BitmapFactory.decodeByteArray(imageData, 0, imageData.length);

            // Seteamos imagen a imageview
            if (bitmap != null) {
                imageView.setImageBitmap(bitmap);
            } else {
                imageView.setImageResource(R.drawable.error);
            }
        }

        // Cargar imagen en el fondo
        loadImage();
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
        intent.putExtra("imageUrl", "https://www.telam.com.ar/thumbs/bluesteel/advf/imagenes/2020/06/5ed4e9b33f900_450.jpg");
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
    public void downloadImage(View v){
        DownloadImage image = new DownloadImage();
        image.execute("https://www.telam.com.ar/thumbs/bluesteel/advf/imagenes/2020/06/5ed4e9b33f900_450.jpg");
    }

}