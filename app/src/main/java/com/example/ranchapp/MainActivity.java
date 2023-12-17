package com.example.ranchapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
    }




    public void login(View view) {
        FirebaseUser currentUser= this.mAuth.getCurrentUser();
        if (currentUser != null){
                Intent intent = new Intent(this, WelcomeActivity.class);
                startActivity(intent);
        }else{
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }

    }


    public void singUp(View view) {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }




    public void logout(View view){
        View btnLogin = findViewById(R.id.login);
        View btnAction = findViewById(R.id.Registro);
        View btnLogout = findViewById(R.id.logout);
        View text = findViewById(R.id.textView);
        btnLogin.setVisibility(View.VISIBLE);
        btnAction.setVisibility(View.VISIBLE);
        text.setVisibility(View.VISIBLE);
        btnLogout.setVisibility(View.GONE);



    }






}