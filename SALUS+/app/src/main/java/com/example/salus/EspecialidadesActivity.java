package com.example.salus;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.salus.adaptador.EspecialidadesAdapter;
import com.example.salus.entidad.Especialidad;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EspecialidadesActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private EspecialidadesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_especialidades);

        recyclerView = findViewById(R.id.recyclerViewEspecialidades);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.110:8000/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();


        ApiDjango api = retrofit.create(ApiDjango.class);
        Call<List<Especialidad>> call = api.getEspecialidades();
        call.enqueue(new Callback<List<Especialidad>>() {
            @Override
            public void onResponse(Call<List<Especialidad>> call, Response<List<Especialidad>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Especialidad> especialidades = response.body();
                    for (Especialidad especialidad : especialidades) {
                        // Log para verificar los datos
                        Log.d("Especialidad", "Nombre: " + especialidad.getNombre() + ", Precio: " + especialidad.getPrecio() + ", Duracion: " + especialidad.getDuracion());
                    }
                    adapter = new EspecialidadesAdapter(especialidades);
                    recyclerView.setAdapter(adapter);
                } else {
                    Toast.makeText(EspecialidadesActivity.this, "Error al obtener especialidades", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Especialidad>> call, Throwable t) {
                Toast.makeText(EspecialidadesActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("Error request", t.toString());
            }
        });
    }
}

