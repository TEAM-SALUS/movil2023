package com.example.salus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class ServiciosOdon extends AppCompatActivity implements View.OnClickListener{
    Button ReservaT;
    private Spinner spinner;
    private Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicios_odon);
        ReservaT = findViewById(R.id.BtnReserva);

        //inicializar componentes
        spinner = findViewById(R.id.spinnerProf);
        boton = findViewById(R.id.button);
        ReservaT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ServiciosOdon.this,TurneroActivity.class);
                startActivity(i);
            }
        });

        //Ejecutar al principio
        llenarSpinner();

        //Acciones del Boton
        boton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                mostrarIdSeleccionado();
            }
        });

        ArrayList<Profesional> profesional= new ArrayList<>();
        profesional.add(new Profesional( 1, "Mariano", "Rodriguez"));
        profesional.add(new Profesional( 2, "Claudio", "Quinteros"));
        profesional.add(new Profesional( 3, "Josefina", "Miranda"));
        profesional.add(new Profesional( 4, "Pedro", "Bustamante"));
        profesional.add(new Profesional( 5, "Ariel", "Romero"));
        profesional.add(new Profesional( 6, "Milagros", "Sanchez"));
        profesional.add(new Profesional( 7, "Martín", "Moreno"));
        profesional.add(new Profesional( 8, "Eugenia", "Ordoñez"));
        profesional.add(new Profesional( 9, "Paatricia", "López"));
        profesional.add(new Profesional( 10, "Gabriela", "López"));

        ArrayAdapter<Profesional> adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,profesional);

        spinner.setAdapter(adapter);

        //a la hora de cambiar el objeto nos realiza la siguiente accion
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ServiciosOdon.this, "Realice una selección", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private void mostrarIdSeleccionado() {
        Profesional profesional = (Profesional) spinner.getSelectedItem();
        String mensaje = "El ID seleccionado es "+profesional.getId()+"y pertenece al Profesional "+profesional.getNombre();
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }

    private void llenarSpinner() {
        ArrayList<Profesional> profesional= new ArrayList<>();
        profesional.add(new Profesional( 1, "Mariano", "Rodriguez"));
        profesional.add(new Profesional( 2, "Claudio", "Quinteros"));
        profesional.add(new Profesional( 3, "Josefina", "Miranda"));
        profesional.add(new Profesional( 4, "Pedro", "Bustamante"));
        profesional.add(new Profesional( 5, "Ariel", "Romero"));
        profesional.add(new Profesional( 6, "Milagros", "Sanchez"));
        profesional.add(new Profesional( 7, "Martín", "Moreno"));
        profesional.add(new Profesional( 8, "Eugenia", "Ordoñez"));
        profesional.add(new Profesional( 9, "Paatricia", "López"));
        profesional.add(new Profesional( 10, "Gabriela", "López"));

        ArrayAdapter<Profesional> adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,profesional);

        spinner.setAdapter(adapter);


    }

    private void irTurnero(View view){

    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, TurneroActivity.class);
        SharedPreferences sharedpreferences = getSharedPreferences("shared_login_data",   Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putInt(login.DNI_PROFESIONAL, 22222222);
        editor.commit();
        startActivity(intent);
    }
}