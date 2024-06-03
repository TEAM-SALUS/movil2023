package com.example.salus;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Contacto extends AppCompatActivity {

    Button Wpp;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        Wpp = findViewById(R.id.btnWpp);

        Wpp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String wpurl= "https://wa.me/+543525482570?text=Hola, quiero reservar un turno.";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(wpurl));
                startActivity(i);
            }
        });

    }

    public void enviarMensaje(View view){
        Intent intent = new Intent(this, ContactoMensajeEnviado.class);
        startActivity(intent);
        Toast.makeText(this, "Mensaje enviado", Toast.LENGTH_SHORT).show();
    }
}