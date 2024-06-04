package com.example.salus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.salus.adaptador.RecyclerViewAdaptador;
import com.example.salus.entidad.Servicio;
import com.example.salus.negocio.IServicioNeg;
import com.example.salus.negocio.IUsuarioNeg;
import com.example.salus.negocioImpl.ServicioNegImpl;

import java.util.ArrayList;
import java.util.List;

public class Servicios extends AppCompatActivity {
    private Context context;
    private IServicioNeg serNI;
    private IUsuarioNeg usuNI;
    RecyclerView recyclerViewServicio;
    RecyclerViewAdaptador adaptadorServicio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicios2);
        iniciar();
    }

    private void iniciar(){
        context = getApplicationContext();
        serNI = new ServicioNegImpl();

        recyclerViewServicio = (RecyclerView) findViewById(R.id.recyclerTurno);
        recyclerViewServicio.setLayoutManager(new LinearLayoutManager(context));

        adaptadorServicio = new RecyclerViewAdaptador(serNI.listarTodos(context),context);
        recyclerViewServicio.setAdapter(adaptadorServicio);

        listarServicios();
    }

    public void listarServicios(){
        List<Servicio> lista = (ArrayList<Servicio>)serNI.listarTodos(context);
        if(lista.size() == 0) {
            serNI.insertar(new Servicio(1, "Médicina general", null , true, serNI.listarUno(1, context).getCategoria()), context);
            serNI.insertar(new Servicio(2, "Oftalmología", null , true, serNI.listarUno(2, context).getCategoria()), context);
            serNI.insertar(new Servicio(3, "Pediatría", null , true, serNI.listarUno(3, context).getCategoria()), context);
            serNI.insertar(new Servicio(4, "Endocrinología", null , true, serNI.listarUno(4, context).getCategoria()), context);

        }
        String listaTxt = "";
        for (Servicio s : lista) {
            listaTxt += s.toString() + "\n";
            Log.d("Servicio ",s.toString());
        }
        Toast.makeText(context,"SERVICIOS",Toast.LENGTH_LONG).show();
        Log.d("Lista Servicio ",listaTxt);
    }










/*


    public List<ServicioModelo> obtenerServicio(){
        List<ServicioModelo> servicio = new ArrayList<>();
        servicio.add(new ServicioModelo(R.drawable.img_servicios, "Medicina general"));
        servicio.add(new ServicioModelo(R.drawable.img_servicios, "Odontología"));
        servicio.add(new ServicioModelo(R.drawable.img_servicios, "Pediatría"));
        servicio.add(new ServicioModelo(R.drawable.img_servicios, "Endocrinología"));

        return servicio;
    }


 */



    public void irServiciosOdon(View view){
        Intent intent = new Intent(this, ServiciosOdon.class);
        startActivity(intent);
    }


}