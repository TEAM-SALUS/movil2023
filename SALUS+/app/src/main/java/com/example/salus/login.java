package com.example.salus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.salus.entidad.Usuario;
import com.example.salus.negocio.IUsuarioNeg;
import com.example.salus.negocioImpl.UsuarioNegImpl;

import java.util.ArrayList;

public class login extends AppCompatActivity implements View.OnClickListener{
    Button btnIngresar;
    Context context;
    EditText loginEmail;
    EditText loginPass;
    IUsuarioNeg iUsuarioNeg;
    String email;
    String pass;

    public static final String DNI_CLIENT="DNICLIENTE";
    public static final String DNI_PROFESIONAL="DNIPROFECIONAL";
    public static final String COD_SERVICIO="CODSERVICIOS";
    public static final String FECHA_TURNO="FECHATURNO";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
<<<<<<< HEAD
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
=======
        Button btn_ingresar = findViewById(R.id.btn_ingresar);
        btn_ingresar.setOnClickListener(new View.OnClickListener() {
            EditText username = findViewById(R.id.login_user);
            EditText password = findViewById(R.id.login_pass);
            HttpLoggingInterceptor loggin = new HttpLoggingInterceptor();
            @Override
            public void onClick(View view) {
                String user = username.getText().toString().trim();
                String pass = password.getText().toString().trim();
                loggin.setLevel(HttpLoggingInterceptor.Level.BODY);
                OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
                httpClient.addInterceptor(loggin);
                Retrofit retrofit = new Retrofit.Builder()

                        .baseUrl(URLConection.URLPrivada)
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(httpClient.build())
                        .build();
                ApiDjango login = retrofit.create(ApiDjango.class);
                Call<Autorizacion> call = login.LOGIN_CALL(user, pass);

                if(user.isEmpty()){
                    username.setError("El nombre de usuario es requerido");
                } else if (pass.isEmpty()) {
                    password.setError("La contraaseña es requerida");
                }else{
                    call.enqueue(new Callback<Autorizacion>() {
                        @Override
                        public void onResponse(Call<Autorizacion> call, Response<Autorizacion> response) {
                            if(response.isSuccessful() && response.body() != null){
                                username.getText().clear();
                                password.getText().clear();
                                String tokenInter = response.body().getToken();
                                Intent intent = new Intent(login.this, home.class);
                                intent.putExtra("token", tokenInter);
                                startActivity(intent);
                                Toast.makeText(login.this, "Bienvenido", Toast.LENGTH_SHORT).show();
                            }else{
                                Toast.makeText(login.this, "Error en las credenciales", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<Autorizacion> call, Throwable t) {
                            Toast.makeText(login.this, t.toString(), Toast.LENGTH_SHORT).show();
                            Log.e("Error request", t.toString());
                        }
                    });
                }

            }
        });
>>>>>>> feature
    }

    public void ingresar(){
        iUsuarioNeg = new UsuarioNegImpl();
        email = loginEmail.getText().toString();
        pass = loginPass.getText().toString();
        Usuario user = new Usuario();
        user = (Usuario) iUsuarioNeg.login(email, pass, context);
        int res = user.getDni();
        Intent intent;
        if (res != -1){
            Toast.makeText(context, "Usuario logueado", Toast.LENGTH_LONG).show();
            SharedPreferences sharedpreferences = getSharedPreferences("shared_login_data",   Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putInt(DNI_CLIENT,user.getDni());
            editor.commit();
            intent = new Intent(this, home.class);
            startActivity(intent);
        }else{
            Toast.makeText(context, "Usuario y contraseña incorrectos", Toast.LENGTH_LONG).show();
        }
    }
}