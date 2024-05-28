package com.example.salus;

import androidx.appcompat.app.AlertDialog;
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

import com.example.salus.adaptador.TurnosAdaptador;
import com.example.salus.dao.URLConection;
import com.example.salus.entidad.Turno;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Turnos extends AppCompatActivity {
    private RecyclerView recyclerTurno;
    private TurnosAdaptador turnosAdaptador;
    private Context context;
    private ApiDjango api;
    ImageButton turno_wpp;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turnos);
        context = getApplicationContext();
        recyclerTurno = findViewById(R.id.recyclerTurno);
        recyclerTurno.setLayoutManager(new LinearLayoutManager(context));
        turno_wpp = findViewById(R.id.turno_wpp);

        turno_wpp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String wppurl = "https://wa.me/+543525482570?text=¡Hola! Quiero solicitar información sobre los servicios y reservar un turno.";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(wppurl));
                startActivity(i);
            }
        });

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URLConection.URLPrivada)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();

        api = retrofit.create(ApiDjango.class);

        // Obtener toda la lista de los turnos
        Call<List<Turno>> call = api.getTurnos();
        call.enqueue(new Callback<List<Turno>>() {
            @Override
            public void onResponse(Call<List<Turno>> call, Response<List<Turno>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Turno> turnosLista = response.body();
                    for (Turno turno : turnosLista) {
                        Log.d("TURNO", String.valueOf(turno.getFecha()));
                    }
                    turnosAdaptador = new TurnosAdaptador(turnosLista, Turnos.this, api);
                    recyclerTurno.setAdapter(turnosAdaptador);
                    Toast.makeText(Turnos.this, "API funcionando", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Turnos.this, "No se encontraron datos", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Turno>> call, Throwable t) {
                Log.e("Turnos", "Error al realizar la llamada a la API.", t);
                Toast.makeText(Turnos.this, "Error. Detalles: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void eliminarTurno(int id, int position) {
        Call<Void> callEliminar = api.eliminarTurno(id);
        callEliminar.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    turnosAdaptador.eliminarItem(position);
                    Toast.makeText(Turnos.this, "Turno eliminado", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Turnos.this, "Error al eliminar el turno", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(Turnos.this, "Error en la conexión", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
