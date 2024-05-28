package com.example.salus.adaptador;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.salus.ConsultaActivity;
import com.example.salus.R;
import com.example.salus.entidad.RegistroDeConsulta;
import com.example.salus.home;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ConsultasAdaptador extends RecyclerView.Adapter<ConsultasAdaptador.ViewHolder> {
    private List<RegistroDeConsulta> registroDeConsultasList;
    private Context context;

    public ConsultasAdaptador(List<RegistroDeConsulta> registroDeConsultasList, Context context){
        this.registroDeConsultasList = registroDeConsultasList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tarjeta_consultas,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ConsultasAdaptador.ViewHolder holder, int position) {
        holder.textFecha.setText(registroDeConsultasList.get(position).getFecha().toString());
        holder.textHora.setText(registroDeConsultasList.get(position).getHora().toString());
        holder.textSintomas.setText(registroDeConsultasList.get(position).getSintomas());
        holder.textDiagnostico.setText(registroDeConsultasList.get(position).getDiagnostico());
        holder.textTratamiento.setText(registroDeConsultasList.get(position).getTratamiento());
        holder.btnConsulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ConsultaActivity.class);
                Toast.makeText(context,"Selecciono a:" + registroDeConsultasList.get(position).getFecha(),Toast.LENGTH_LONG).show();
                intent.putExtra("consultaSeleccionada",registroDeConsultasList.get(position).getId());
                intent.putExtra("turnoSeleccionado",registroDeConsultasList.get(position).getId_turno());
                context.startActivity(Intent.createChooser(intent,"Compartir en").addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
            }
        });
    }

    @Override
    public int getItemCount() {
        return registroDeConsultasList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textFecha;
        private TextView textHora;
        private TextView textSintomas;
        private TextView textDiagnostico;
        private TextView textTratamiento;
        private Button btnConsulta;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textFecha = itemView.findViewById(R.id.textFecha);
            textHora = itemView.findViewById(R.id.textHora);
            textSintomas = itemView.findViewById(R.id.textSintomas);
            textDiagnostico = itemView.findViewById(R.id.textDiagnostico);
            textTratamiento = itemView.findViewById(R.id.textTratamiento);
            btnConsulta = itemView.findViewById(R.id.btnConsulta);
        }
    }

}
