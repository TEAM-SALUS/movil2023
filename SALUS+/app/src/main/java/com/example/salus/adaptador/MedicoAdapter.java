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
import com.example.salus.entidad.Medico;

import java.util.List;

public class MedicoAdapter extends RecyclerView.Adapter<MedicoAdapter.ViewHolder> {
    private List<Medico> medicos;

    public MedicoAdapter (List<Medico> medicos) {
        this.medicos = medicos;
    }

    @NonNull
    @Override
    public MedicoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_especialidad, parent, false);
        return new MedicoAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MedicoAdapter.ViewHolder holder, int position) {
        Medico medico = medicos.get(position);

        holder.mNombre.setText(medico.getNombre());

        holder.mApellido.setText(medico.getApellido());

        // Convertir el precio a cadena y mostrarlo
        holder.mEspecialidad.setText(String.valueOf(medico.getId_especialidad()));


        // Cargar la imagen con Glide
        Glide.with(holder.itemView.getContext())
                .load(medico.getFoto())
                .into(holder.ivFoto);
    }

    @Override
    public int getItemCount() {
        return medicos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView mNombre, mApellido, mEspecialidad;
        ImageView ivFoto;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mNombre = itemView.findViewById(R.id.prTitulo);
            mEspecialidad = itemView.findViewById(R.id.prEspecialidad);
            ivFoto = itemView.findViewById(R.id.ivFoto);
        }
    }
}



