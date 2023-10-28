package com.example.salus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.salus.entidad.Usuario;

public class login extends AppCompatActivity {
    private Button btnIngresar;
    Context context;
    Usuario usuario;
    EditText loginEmail;
    EditText loginPass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnIngresar = findViewById(R.id.btn_ingresar);
    }
    public void irHome(View view){
        Intent intent = new Intent(this, home.class);
        startActivity(intent);
    }
}