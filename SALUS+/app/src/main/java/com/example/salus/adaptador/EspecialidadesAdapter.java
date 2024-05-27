package com.example.salus.adaptador;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.salus.R;
import com.example.salus.entidad.Especialidad;

import java.util.List;

public class EspecialidadesAdapter extends RecyclerView.Adapter<EspecialidadesAdapter.ViewHolder> {
    private List<Especialidad> especialidades;

    public EspecialidadesAdapter(List<Especialidad> especialidades) {
        this.especialidades = especialidades;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_especialidad, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Especialidad especialidad = especialidades.get(position);
        holder.tvNombre.setText(especialidad.getNombre());

        // Convertir el precio a cadena y mostrarlo
        holder.tvPrecio.setText(String.valueOf(especialidad.getPrecio()));

        // Mostrar la duración como cadena
        holder.tvDuracion.setText(especialidad.getDuracion());

        holder.tvDescripcion.setText(especialidad.getDescripcion());

        // Cargar la imagen con Glide
        Glide.with(holder.itemView.getContext())
                .load(especialidad.getFoto())
                .into(holder.ivFoto);
    }

    @Override
    public int getItemCount() {
        return especialidades.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNombre, tvPrecio, tvDuracion, tvDescripcion;
        ImageView ivFoto;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvPrecio = itemView.findViewById(R.id.tvPrecio);
            tvDuracion = itemView.findViewById(R.id.tvDuracion);
            tvDescripcion = itemView.findViewById(R.id.tvDescripcion);
            ivFoto = itemView.findViewById(R.id.ivFoto);
        }
    }
}

