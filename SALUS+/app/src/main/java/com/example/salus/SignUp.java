package com.example.salus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.salus.entidad.Usuario;
import com.example.salus.negocio.IUsuarioNeg;
import com.example.salus.negocioImpl.UsuarioNegImpl;

public class SignUp extends AppCompatActivity implements View.OnClickListener{
    private Button btnRegistrarse;
    Context context;
    TextView signUsuario;
    TextView signEmail;
    TextView signPass;
    Usuario usuario;
    IUsuarioNeg iUsuarioNeg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        init();
    }

    private void init(){
        context = getApplicationContext();
        signUsuario = findViewById(R.id.sign_usuario);
        signEmail = findViewById(R.id.sign_email);
        signPass = findViewById(R.id.sign_pass);
        btnRegistrarse = findViewById(R.id.btn_registrarse);
    }
    private Usuario completarDatos(){
        Usuario u = new Usuario();
        String user = signUsuario.getText().toString();
        String email = signEmail.getText().toString();
        String pass = signPass.getText().toString();
        u.setUsuario(user);
        u.setEmail(email);
        u.setClave(pass);
        return u;
    }

    private void guardar(){
        iUsuarioNeg = new UsuarioNegImpl( );
        Usuario usuario = completarDatos();
        iUsuarioNeg.insertar(usuario, context);
        Toast.makeText(context, "Usuario registrado", Toast.LENGTH_LONG).show();
    }
    public void irLogin(View view){
        Intent intent = new Intent(this, login.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        guardar();
        irLogin(view);
    }
}