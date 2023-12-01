package com.example.ranchapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        //hacer los checkbox o la lista de los eventos y un boton de crear, al darle crear te debe mostrar los enventos creados
    }

    public void create_event(View view){
        Intent intent = new Intent(this, CreateEventActivity.class);
        startActivity(intent);
    }
    public void logOut(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}