package com.example.salus.adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.salus.R;
import com.example.salus.entidad.Turno;

import java.util.List;



public class TurnosAdaptador extends RecyclerView.Adapter<TurnosAdaptador.ViewHolder> {
    private List<Turno> turnoLista;
    private Context context;

    public TurnosAdaptador(List<Turno> turnoLista) {
        this.turnoLista = turnoLista;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_turno, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Turno turno = turnoLista.get(position);
        holder.tv_fecha.setText(String.valueOf(turno.getFecha()));
        holder.tv_hora.setText(String.valueOf(turno.getHorario()));
        holder.tv_profesional.setText(String.valueOf(turno.getId_medico()));


        /*
        holder.botonServicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ServiciosOdon.class);
                SharedPreferences sharedpreferences = context.getSharedPreferences("shared_login_data", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putInt(login.COD_SERVICIO, servicioList.get(position).getCodServicio());
                editor.commit();
                //intent.putExtra("servSeleccionado",servicioList.get(position).getCodServicio());
                context.startActivity(Intent.createChooser(intent,"FUNCIONA").addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return turnoLista.size();
    }



    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView  tv_profesional, tv_hora, tv_fecha;
        //private Button btn_cancelar, btn_modificar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_fecha = (TextView) itemView.findViewById(R.id.tv_fecha);
            tv_hora = (TextView) itemView.findViewById(R.id.tv_hora);
            tv_profesional = (TextView) itemView.findViewById(R.id.tv_profesional);
            //btn_cancelar = (Button) itemView.findViewById(R.id.btn_cancelar);
            //btn_modificar = (Button) itemView.findViewById(R.id.btn_modificar);
        };
    };
};


