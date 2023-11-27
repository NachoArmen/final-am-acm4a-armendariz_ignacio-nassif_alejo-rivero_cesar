package com.example.ranchapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    public void singUpForm(View view) {

        View imagen = findViewById(R.id.img_principal);
        imagen.setVisibility(View.GONE);
        // Crea un nuevo TextView
        TextView myText = new TextView(view.getContext());
        myText.setText("Logueate");
        myText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 50);

        // Crea un nuevo EditText
        EditText editText = new EditText(view.getContext());
        editText.setHint("Ingrese su nombre"); // Establece un texto de sugerencia
        editText.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME); // Establece el tipo de entrada de texto

        EditText editTextMail = new EditText(view.getContext());
        editTextMail.setHint("Ingrese su Email"); // Establece un texto de sugerencia
        editTextMail.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS); //

        // Crea un nuevo EditText para la contraseña
        EditText passwordEditText = new EditText(view.getContext());
        passwordEditText.setHint("Ingrese su contraseña"); // Establece un texto de sugerencia para la contraseña
        passwordEditText.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD); // Establece el tipo de entrada de contraseña

        // Crea un nuevo botón
        Button confirmButton = new Button(view.getContext());
        confirmButton.setText("Sing up"); // Establece el texto del botón

        // Crea un nuevo LinearLayout que actuará como contenedor
        LinearLayout linearLayout = new LinearLayout(view.getContext());
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        // Agrega el TextView y el EditText al LinearLayout
        linearLayout.addView(myText);
        linearLayout.addView(editText);
        linearLayout.addView(passwordEditText);
        linearLayout.addView(editTextMail);
        linearLayout.addView(confirmButton);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        // Agrega el LinearLayout a la vista raíz de la actividad
        ViewGroup rootView = findViewById(android.R.id.content);
        rootView.addView(linearLayout);

    }



}