package com.example.salus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ProfesionalesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profesionales);
    }
    public void irProfesional(View view) {
        Intent intent = new Intent(this, ProfesionalActivity.class);
        startActivity(intent);

    }
}