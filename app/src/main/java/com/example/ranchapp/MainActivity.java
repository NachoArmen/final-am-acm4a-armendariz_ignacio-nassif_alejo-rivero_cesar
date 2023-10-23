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
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void login(View view) {
        // Oculta los botones y el texto existentes
        View btnLogin = findViewById(R.id.login);
        View btnAction = findViewById(R.id.Registro);
        View btnLogout = findViewById(R.id.logout);
        View text = findViewById(R.id.textView);
        btnLogin.setVisibility(View.GONE);
        btnAction.setVisibility(View.GONE);
        text.setVisibility(View.GONE);


        // Crea un nuevo TextView
        TextView myText = new TextView(view.getContext());
        myText.setText("Logueate");
        myText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 50);

        // Crea un nuevo EditText
        EditText editText = new EditText(view.getContext());
        editText.setHint("Ingrese su nombre"); // Establece un texto de sugerencia
        editText.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME); // Establece el tipo de entrada de texto

        // Crea un nuevo EditText para la contraseña
        EditText passwordEditText = new EditText(view.getContext());
        passwordEditText.setHint("Ingrese su contraseña"); // Establece un texto de sugerencia para la contraseña
        passwordEditText.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD); // Establece el tipo de entrada de contraseña

        // Crea un nuevo botón
        Button confirmButton = new Button(view.getContext());
        confirmButton.setText("Login"); // Establece el texto del botón

       
}