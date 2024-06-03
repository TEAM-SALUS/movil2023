package com.example.salus;

import android.content.Intent;
import android.os.Bundle;
import android.content.Context;;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.salus.adaptador.EspecialidadesAdapter;
import com.example.salus.adaptador.MedicoAdapter;
import com.example.salus.dao.URLConection;
import com.example.salus.entidad.Especialidad;
import com.example.salus.entidad.Categoria;
import com.example.salus.entidad.Servicio;
import com.example.salus.entidad.Medicos;

import java.util.List;
import java.util.zip.Inflater;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProfesionalActivity extends AppCompatActivity {
    private Context context;
    private TextView prTitulo;
    private TextView prEspecialidad;
    private TextView prEspecialidades;
    private ImageView imageView4;
    private TextView prDescripcion;
    private Button btn_profesional;
    private MedicoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_profesional);

        prTitulo = findViewById(R.id.prTitulo);

        prEspecialidad = findViewById(R.id.prEspecialidad);

        prEspecialidades = findViewById(R.id.prEspecialidades);

        imageView4 = findViewById(R.id.imageView4);

        prDescripcion = findViewById(R.id.prDescripcion);

        btn_profesional = findViewById(R.id.btn_profesional);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        String matricula_incoming = extras.get("especialidadID").toString();

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URLConection.URLPrivada)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();


        ApiDjango api = retrofit.create(ApiDjango.class);
        Call<List<Medicos>> call = api.getMedicos();
        call.enqueue(new Callback<List<Medicos>>() {
            @Override
            public void onResponse(Call<List<Medicos>> call, Response<List<Medicos>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Medicos> MedicoList = response.body();
                    for (Medicos medicos : MedicoList) {

                        String matricula_find = medicos.getMatricula();

                        String especialidad_find = medicos.getId_especialidad();

                        if (especialidad_find.equals(matricula_incoming)) {

                            String titulo = medicos.getNombre() + " " + medicos.getApellido();

                            prTitulo.setText(titulo);

                            prDescripcion.setText("Matricula: " + matricula_find + "\nTelefono: " + medicos.getTelefono());

                            String medico_find = medicos.getId();


                            Call<List<Especialidad>> callE = api.getEspecialidades();
                            callE.enqueue(new Callback<List<Especialidad>>() {
                                @Override
                                public void onResponse(Call<List<Especialidad>> call, Response<List<Especialidad>> response) {
                                    if (response.isSuccessful() && response.body() != null) {
                                        List<Especialidad> especialidades = response.body();
                                        for (Especialidad especialidad : especialidades) {
                                            String especialidadID = especialidad.getId().toString();
                                            Log.d("especialidades:", especialidadID);
                                            if (especialidad_find.equals(especialidadID)) {
                                                prEspecialidad.setText(especialidad.getNombre());
                                                prEspecialidades.setText(especialidad.getDescripcion());

                                                btn_profesional.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View v) {
                                                        Intent intento = new Intent(ProfesionalActivity.this, Turnero_Medicos.class);
                                                        intento.putExtra("Medico",prTitulo.getText());
                                                        intento.putExtra("Especialidad",prEspecialidad.getText());
                                                        intento.putExtra("MedicoID",medico_find);
                                                        intento.putExtra("EspecialidadID",especialidadID);
                                                        startActivity(Intent.createChooser(intento,"Compartir en").addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                                                    }
                                                });
                                            }
                                        }
                                    } else {
                                        Toast.makeText(ProfesionalActivity.this, "Error al obtener especialidades", Toast.LENGTH_SHORT).show();
                                    }
                                }

                                @Override
                                public void onFailure(Call<List<Especialidad>> call, Throwable t) {
                                    Toast.makeText(ProfesionalActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                                    Log.e("Error request", t.toString());
                                }
                            });
                        }
                    }

                } else {
                    Toast.makeText(ProfesionalActivity.this, "Error al obtener medico", Toast.LENGTH_SHORT).show();
                }

            }



            @Override
            public void onFailure(Call<List<Medicos>> call, Throwable t) {
                Toast.makeText(ProfesionalActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("Error request", t.toString());
            }

            public void onClick(View v) {
                Intent i = new Intent ( ProfesionalActivity.this,Turnero_Medicos.class);
                //i.putExtra("dniCliente",(int) extras.get("dniCliente"));
                startActivity(i);

            }
        });


    }
}