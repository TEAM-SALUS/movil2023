package com.example.salus.adaptador;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.salus.ProfesionalActivity;
import com.example.salus.R;
import com.example.salus.entidad.ServicioXProfesional;

import java.util.List;

public class ProfesionalesAdaptador extends RecyclerView.Adapter<ProfesionalesAdaptador.ViewHolder> {
    private List<ServicioXProfesional> servicioXProfesionalList;
    private Context context;
    public ProfesionalesAdaptador(List<ServicioXProfesional> servicioXProfesionalList, Context context) {
        this.servicioXProfesionalList = servicioXProfesionalList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tarjeta_profesionales,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imgProfesionales.setImageResource(R.drawable.dr_pequena_1);
        holder.txtNombreProfesionales.setText(servicioXProfesionalList.get(position).getUsuario_SXP().getNombre());
        holder.txtEspecialidadProfesional.setText(servicioXProfesionalList.get(position).getServicio_SXP().getCategoria().getDescripcion());
        holder.btnProfesionales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ProfesionalActivity.class);
                Toast.makeText(context,"Selecciono a: " + servicioXProfesionalList.get(position).getUsuario_SXP().getNombre(),Toast.LENGTH_LONG).show();
                intent.putExtra("proSeleccionado",servicioXProfesionalList.get(position).getUsuario_SXP().getDni());
                intent.putExtra("especialidadSeleccionada",servicioXProfesionalList.get(position).getServicio_SXP().getCodServicio());
                context.startActivity(Intent.createChooser(intent,"compartir en").addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
            }
        });
    }

    @Override
    public int getItemCount() {
        return servicioXProfesionalList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgProfesionales;
        private TextView txtNombreProfesionales;
        private TextView txtEspecialidadProfesional;
        private Button btnProfesionales;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgProfesionales = itemView.findViewById(R.id.imgProfesionales);
            txtNombreProfesionales = itemView.findViewById(R.id.txtNombreProfesionales);
            txtEspecialidadProfesional = itemView.findViewById(R.id.txtEspecialidadProfesionales);
            btnProfesionales = itemView.findViewById(R.id.btnProfesionales);
        }
    }
}
