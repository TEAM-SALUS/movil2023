package com.example.salus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ServiciosActivity extends AppCompatActivity {

    Button reservarTurno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicios);

        reservarTurno = (Button)findViewById(R.id.reservarTurno1);
        reservarTurno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent i = new Intent(createPackageContext(ServiciosActivity.this, ConfirmarTurnoActivity.class));
            }
        });
    }

    private Intent createPackageContext(ServiciosActivity serviciosActivity, Class<ConfirmarTurnoActivity> confirmarTurnoActivityClass) {
        return null;
    }
}