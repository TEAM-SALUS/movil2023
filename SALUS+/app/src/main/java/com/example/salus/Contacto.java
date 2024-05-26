package com.example.salus;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class Contacto extends AppCompatActivity {

    ImageButton contacto_wpp;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        contacto_wpp = findViewById(R.id.contacto_wpp);

        contacto_wpp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String wppurl= "https://wa.me/+543525482570?text=¡Hola! Quiero solicitar información acerca" +
                        "de los servicios que ofrecen.";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(wppurl));
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