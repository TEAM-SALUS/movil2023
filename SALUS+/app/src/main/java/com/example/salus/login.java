package com.example.salus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.salus.entidad.Usuario;
import com.example.salus.negocio.IUsuarioNeg;
import com.example.salus.negocioImpl.UsuarioNegImpl;

public class login extends AppCompatActivity implements View.OnClickListener{
    Button btnIngresar;
    Context context;
    EditText loginEmail;
    EditText loginPass;
    IUsuarioNeg iUsuarioNeg;
    String email;
    String pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }
    private void init(){
        context = getApplicationContext();
        btnIngresar = findViewById(R.id.btn_ingresar);
        loginEmail = findViewById(R.id.login_email);
        loginPass = findViewById(R.id.login_pass);
    }
    public void irHome(View view){
        Intent intent = new Intent(this, home.class);
        startActivity(intent);
    }
    @Override
    public void onClick(View view) {
        ingresar();
    }

    public void ingresar(){
        iUsuarioNeg = new UsuarioNegImpl();
        email = loginEmail.getText().toString();
        pass = loginPass.getText().toString();
        int res = iUsuarioNeg.login(email, pass, context);
        if (res==1){
            Toast.makeText(context, "Usuario logueado", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, home.class);
            startActivity(intent);
        }else{
            Toast.makeText(context, "Usuario y contraseña incorrectos", Toast.LENGTH_LONG).show();
        }
    }
}