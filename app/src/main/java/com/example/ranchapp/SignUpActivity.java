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

import com.google.firebase.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

public class SignUpActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    private EditText name;
    private EditText email;
    private  EditText password;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mAuth = FirebaseAuth.getInstance();
        name = findViewById(R.id.editTextNombre);
        email = findViewById(R.id.editTextMail);
        password = findViewById(R.id.editTextClave);

    }

    public void singUpForm(View view) {
        String mail = email.getText().toString();
        String pass = password.getText().toString();

        mAuth.createUserWithEmailAndPassword(mail,pass)
                .addOnCompleteListener(this, task -> {

                    if (task.isSuccessful()) {
                        FirebaseUser user = mAuth.getCurrentUser();
                        if (user != null) {
                            String username = name.getText().toString();
                            UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                                    .setDisplayName(username).build();

                            user.updateProfile(profileUpdates)
                                    .addOnCompleteListener(task1 -> {

                                        if (task1.isSuccessful()) {
                                            Toast.makeText(SignUpActivity.this, "Registro Completado", Toast.LENGTH_SHORT).show();
                                            Intent intent = new Intent(this, LoginActivity.class);
                                            startActivity(intent);
                                            finish();
                                        }
                                    });
                        }
                    }
                }).addOnFailureListener(e->{
                    Toast.makeText(SignUpActivity.this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();

                });








    }



}