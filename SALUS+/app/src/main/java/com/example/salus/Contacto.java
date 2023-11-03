package com.example.salus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class Contacto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);
    }

    public void enviarMensaje(){
        Toast.makeText(this, "Mensaje enviado", Toast.LENGTH_SHORT).show();
    }
}