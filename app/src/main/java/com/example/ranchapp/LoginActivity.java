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

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText email;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
        email = findViewById(R.id.editTextNombreLog);
        password = findViewById(R.id.editTextPasswordLog);
    }



    // Metodo del onClick de boton login
    public void log(View view){
        String mail = email.getText().toString();
        String pass = password.getText().toString();

        mAuth.signInWithEmailAndPassword(mail,pass)
                .addOnCompleteListener(this, task -> {
            if (task.isSuccessful()){
                FirebaseUser currentUser = mAuth.getCurrentUser();
                Boolean validated = currentUser.isEmailVerified();
                if (!validated){
                    Toast.makeText(LoginActivity.this, "Por favor verifique su email.", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent(this, WelcomeActivity.class);
                    startActivity(intent);
                    finish();
                }

            }else {
                Toast.makeText(LoginActivity.this, "Campos Incorrectos.Intente de nuevo", Toast.LENGTH_SHORT).show();
            }
        });

    }



    public void toSignUp(View view){
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);


    }



}