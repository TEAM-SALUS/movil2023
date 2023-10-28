package com.example.salus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;

import com.example.salus.adaptador.RecyclerViewAdaptador;
import com.example.salus.entidad.Servicio;
import com.example.salus.negocio.ICategoriaNeg;
import com.example.salus.negocio.ICondicionNeg;
import com.example.salus.negocio.IServicioNeg;
import com.example.salus.negocio.IServicioXProfesionalNeg;
import com.example.salus.negocio.ITurnoNeg;
import com.example.salus.negocio.IUsuarioNeg;
import com.example.salus.negocioImpl.ServicioModelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Servicios extends AppCompatActivity {
    private Context context;
    private ICategoriaNeg catNI;
    private ICondicionNeg conNI;
    private IServicioNeg serNI;
    private IUsuarioNeg usuNI;
    private IServicioXProfesionalNeg serXProNI;
    private ITurnoNeg turNI;
    private RecyclerView recyclerViewServicio;
    private RecyclerViewAdaptador adaptadorServicio;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewServicio = (RecyclerView) findViewById(R.id.recyclerServicio);
        recyclerViewServicio.setLayoutManager(new LinearLayoutManager(this));

        adaptadorServicio = new RecyclerViewAdaptador(obtenerServicio());
        recyclerViewServicio.setAdapter(adaptadorServicio);
    }


    public void listarServicios(){
        List<Servicio> lista = (ArrayList<Servicio>)serNI.listarTodos(context);

        String text = "";
        for (Servicio serv : lista){
            text += serv.toString();
        }
    }













    public List<ServicioModelo> obtenerServicio(){
        List<ServicioModelo> servicio = new ArrayList<>();
        servicio.add(new ServicioModelo(R.drawable.img_servicios, "Medicina general"));
        servicio.add(new ServicioModelo(R.drawable.img_servicios, "Odontología"));
        servicio.add(new ServicioModelo(R.drawable.img_servicios, "Pediatría"));
        servicio.add(new ServicioModelo(R.drawable.img_servicios, "Endocrinología"));

        return servicio;
    }



    public void irServiciosOdon(View view){
        Intent intent = new Intent(this, ServiciosOdon.class);
        startActivity(intent);
    }


}