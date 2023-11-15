package com.example.salus;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ContactoMensajeEnviado extends AppCompatActivity {
    Button volver;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto_mensaje_enviado);

        volver = findViewById(R.id.volverHome);
    }

    public void irHome(View view){
        Intent intent = new Intent(this, home.class);
        startActivity(intent);
    }
}