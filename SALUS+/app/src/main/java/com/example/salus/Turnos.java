package com.example.salus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.salus.adaptador.DateTypeAdapter;
import com.example.salus.adaptador.TimeTypeAdapter;
import com.example.salus.adaptador.TurnosAdaptador;
import com.example.salus.entidad.Turno;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Turnos extends AppCompatActivity {
    //ImageButton turno_wpp;
    private RecyclerView recyclerTurno;
    private TurnosAdaptador turnosAdaptador;
    private Context context;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turnos);
        context = getApplicationContext();
        recyclerTurno = findViewById(R.id.recyclerTurnos);
        recyclerTurno.setLayoutManager(new LinearLayoutManager(context));

        /*
        turno_wpp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String wppurl = "https://wa.me/+543525482570?text=¡Hola! Quiero solicitar información sobre los servicios y reservar un turno.";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(wppurl));
                startActivity(i);
            }
        });

         */

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.92:8000/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();

        ApiDjango api = retrofit.create(ApiDjango.class);

        Call<List<Turno>> call = api.getTurnos();
        call.enqueue(new Callback<List<Turno>>() {
             @Override
             public void onResponse(Call<List<Turno>> call, Response<List<Turno>> response) {
                 if (response.isSuccessful() && response.body() != null) {
                     List<Turno> turnosLista = response.body();
                     for (Turno turno : turnosLista){
                         Log.d("TURNO " , String.valueOf(turno.getFecha()));
                     };
                     turnosAdaptador = new TurnosAdaptador(turnosLista);
                     recyclerTurno.setAdapter(turnosAdaptador);
                     Toast.makeText(Turnos.this, "API funcionando", Toast.LENGTH_SHORT).show();
                 } else {
                     Toast.makeText(Turnos.this, "No se encontraron datos", Toast.LENGTH_SHORT).show();
                 };
             };

             @Override
             public void onFailure(Call<List<Turno>> call, Throwable t) {
                 Log.e("Turnos", "Error al realizar la llamada a la API.", t);
                 Toast.makeText(Turnos.this, "Error. Detalles: " + t.getMessage(), Toast.LENGTH_SHORT).show();
             }
         });
    };
};



//_______________________________________________________________________
       /* btn_modificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getTurno();
            }
        });
    }

    private void getTurno(){
        String api_url = "https://jsonplaceholder.typicode.com/posts/1";

        StringRequest getRequest = new StringRequest(Request.Method.GET, api_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);

                    // Traemos los elementos que nos dara la BD y pintamos los TextView con la información
                    tv_especialidad.setText(jsonObject.getString("title"));

                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        Volley.newRequestQueue(this).add(getRequest);

    }*/

