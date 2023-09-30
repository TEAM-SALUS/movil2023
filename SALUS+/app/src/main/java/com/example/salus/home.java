package com.example.salus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class home extends AppCompatActivity {
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        imageView = findViewById(R.id.imgProfesionales_home);
    }
    public void irProfesionales(View view){
        Intent intent = new Intent(this, ProfesionalesActivity.class);
        startActivity(intent);
    }
}