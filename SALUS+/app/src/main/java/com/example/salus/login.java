package com.example.salus;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.salus.entidad.Autorizacion;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class login extends AppCompatActivity {
    public static final String TOKEN="TOKEN";
    public static final String DNI_CLIENT="DNICLIENTE";
    public static final String COD_SERVICIO="CODSERVICIO";
    public static final String DNI_PROFESIONAL="DNIPROFESIONAL";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button btn_ingresar = findViewById(R.id.btn_ingresar);
        btn_ingresar.setOnClickListener(new View.OnClickListener() {
            EditText username = findViewById(R.id.login_email);
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
                        .baseUrl("http://192.168.1.9:8000/api/v1/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(httpClient.build())
                        .build();
                ApiDjango login = retrofit.create(ApiDjango.class);
                Call<Autorizacion> call = login.LOGIN_CALL(user, pass);
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
        });
    }
}


