package com.example.salus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Servicios extends AppCompatActivity {

    private Button reservarTurno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicios2);

        reservarTurno = findViewById(R.id.reservarTurno1);
    }

        /*
    public void irConfirmarServicio(View view){
        Intent intent = new Intent(this, ConfirmarServicioActivity.class);
        startActivity(intent);
    }
         */
}