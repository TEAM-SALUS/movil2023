package com.example.salus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ServiciosOdon extends AppCompatActivity implements View.OnClickListener{
    Button ReservaT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicios_odon);
        ReservaT = findViewById(R.id.IdBtnReserva);
    }

    private void irTurnero(View view){

    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, TurneroActivity.class);
        SharedPreferences sharedpreferences = getSharedPreferences("shared_login_data",   Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putInt(login.DNI_PROFESIONAL, 22222222);
        editor.commit();
        startActivity(intent);
    }
}