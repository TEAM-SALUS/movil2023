package com.example.salus;

import static com.example.salus.login.DNI_CLIENT;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

//import com.example.salus.adaptador.CalendarAdapter;

import com.example.salus.datos.IServicioXProfesionalDao;
import com.example.salus.datos.IUsuarioDao;
import com.example.salus.entidad.Servicio;
import com.example.salus.entidad.ServicioXProfesional;
import com.example.salus.entidad.Turno;
import com.example.salus.entidad.Usuario;
import com.example.salus.negocio.IServicioXProfesionalNeg;
import com.example.salus.negocio.ITurnoNeg;
import com.example.salus.negocio.IUsuarioNeg;
import com.example.salus.negocioImpl.TurnoNegImpl;
import com.example.salus.negocioImpl.UsuarioNegImpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class TurneroActivity extends AppCompatActivity {
    private Button reservar;
    private TextView txtFecha;
    private Button btnFecha;
    private TextView txtHora;
    private Button btnHora;
    private Spinner spinner;
    IUsuarioNeg iUsuarioNeg;
    Context context;
    ITurnoNeg iTurnoNeg;
    Turno turno;
    int hora;
    int minutos;
    int dia;
    int mes;
    int anio;

    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_turnero);
        reservar = findViewById(R.id.btnReservarCita);
        txtFecha = findViewById(R.id.txt_fecha);
        btnFecha = findViewById(R.id.btn_fecha);
        txtHora = findViewById(R.id.txt_hora);
        btnHora = findViewById(R.id.btn_hora);
        spinner = findViewById(R.id.spinner);
        context = getApplicationContext();
        List<Usuario> listaProf = llenarProfesionales();
        ArrayAdapter<Usuario> arrayAdapter = new ArrayAdapter<>(context, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, listaProf);
        spinner.setAdapter(arrayAdapter);
    }

    private List<Usuario> llenarProfesionales() {
        List listaProf;
        iUsuarioNeg = new UsuarioNegImpl();
        listaProf = iUsuarioNeg.listarTodos(context);
        return listaProf;
    }

    public void abrirCalendario(View view) {
        Calendar calendar = Calendar.getInstance();
        anio = calendar.get(Calendar.YEAR);
        mes = calendar.get(Calendar.MONTH);
        dia = calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog dpd = new DatePickerDialog(TurneroActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                anio = i;
                mes = i1 + 1;
                dia = i2;
                String fecha = dia + "/" + mes + "/" + anio;
                txtFecha.setText(fecha);
            }
        }, anio, mes, dia);
        dpd.show();
    }

    public void abrirRejoj(View view) {
        Calendar time = Calendar.getInstance();
        hora = time.get(Calendar.HOUR_OF_DAY);
        minutos = time.get(Calendar.MINUTE);
        TimePickerDialog tpd = new TimePickerDialog(TurneroActivity.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                hora = i;
                minutos = i1;
                String horario = hora + ":" + minutos;
                txtHora.setText(horario);
            }
        }, 0, 0, false);
        tpd.show();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private Turno completarDatos() {
        Turno t = new Turno();

        Usuario u = new Usuario();
        SharedPreferences sharedpreferences = getSharedPreferences("shared_login_data", Context.MODE_PRIVATE);
        u.setDni(sharedpreferences.getInt(DNI_CLIENT, Context.MODE_PRIVATE));

        Usuario us = new Usuario();
        us.setDni(22222222);

        Servicio se = new Servicio();
        se.setCodServicio(1);

        ServicioXProfesional s = new ServicioXProfesional();
        s.setServicio_SXP(se);
        s.setUsuario_SXP(us);

        //t.setCodTurno();
        t.setFecha(LocalDateTime.of(anio, mes, dia, hora, minutos));
        t.setFechaAsignacion(LocalDateTime.now());
        t.setEstado(true);
        t.setUsuarioCli(u);
        t.setServicioXProfesional(s);
        return t;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void irTurnos(View view) {
        iTurnoNeg = new TurnoNegImpl();
        turno = completarDatos();
        Log.d("datos", turno.toString());
        boolean res = iTurnoNeg.insertar(turno, context);
        Log.d("res", String.valueOf(res));
        if (res) {
            Toast.makeText(context, "Turno registrado", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, home.class);
            startActivity(intent);
        } else {
            Toast.makeText(context, "Registro falló", Toast.LENGTH_LONG).show();
        }
    }
}