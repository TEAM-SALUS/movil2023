package com.example.salus.adaptador;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.salus.R;
import com.example.salus.Servicios;
import com.example.salus.entidad.Servicio;
import com.example.salus.entidad.ServicioXProfesional;
import com.example.salus.negocioImpl.ServicioModelo;

import java.util.List;



public class RecyclerViewAdaptador extends RecyclerView.Adapter<RecyclerViewAdaptador.ViewHolder> {
    private List<Servicio> servicioList;
    private Context context;

    public RecyclerViewAdaptador(List<Servicio> servicioList, Context context) {
        this.servicioList = servicioList;
        this.context = context;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView fotoServicio;
        private TextView servicio;
        private Button botonServicio;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            fotoServicio = (ImageView) itemView.findViewById(R.id.imgServicio);
            servicio = (TextView) itemView.findViewById(R.id.tvServicio);
            botonServicio = (Button) itemView.findViewById(R.id.btnServicio);
        }
    }


    // public List<ServicioModelo> ServicioLista;





    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_servicio, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.fotoServicio.setImageResource(R.drawable.img_servicios);
        holder.servicio.setText(servicioList.get(position).getTitulo());

        holder.botonServicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Servicios.class);
                context.startActivity(Intent.createChooser(intent,"FUNCIONA").addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
            }
        });
    }


    @Override
    public int getItemCount() {
        return servicioList.size();
    }
}


