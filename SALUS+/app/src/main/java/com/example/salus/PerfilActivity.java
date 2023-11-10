package com.example.salus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import com.example.salus.entidad.Condicion;
import com.example.salus.entidad.Usuario;
import com.example.salus.negocioImpl.CondicionNegImpl;
import com.example.salus.negocioImpl.UsuarioNegImpl;

import java.util.ArrayList;

public class PerfilActivity extends AppCompatActivity {
    private Context context;
    private UsuarioNegImpl usuNI;
    private CondicionNegImpl conNI;
    private TextView txtDni;
    private EditText txtNombre;
    private EditText txtApellido;
    private EditText txtDireccion;
    private EditText txtCiudad;
    private EditText txtTelefono;
    private EditText txtEmail;
    private EditText txtUsuario;
    private EditText txtClave;
    private EditText txtDescripcion;
    private EditText txtEstado;
    private Spinner spCondicion;
    ArrayList<Condicion> listaCondicion ;
    ArrayAdapter<Condicion> arrayAdapter;
    private Switch swEditar;
    private Button btnConfirmar;
    private SharedPreferences sharedpreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        iniciar();
    }
    private void iniciar() {
        context = getApplicationContext();
        usuNI = new UsuarioNegImpl();
        conNI = new CondicionNegImpl();
        txtDni = findViewById(R.id.txtDni_perfil);
        txtNombre = findViewById(R.id.txtNombre_perfil);
        txtApellido = findViewById(R.id.txtApellido_perfil);
        txtDireccion = findViewById(R.id.txtDireccion_perfil);
        txtCiudad = findViewById((R.id.txtCiudad_perfil));
        txtTelefono = findViewById(R.id.txtTelefono_perfil);
        txtEmail = findViewById(R.id.txtEmail_perfil);
        txtUsuario = findViewById(R.id.txtUsuario_perfil);
        txtClave = findViewById(R.id.txtClave_perfil);
        txtDescripcion = findViewById(R.id.txtDescripcion_perfil);
        txtEstado = findViewById(R.id.txtEstado_perfil);
        listaCondicion = (ArrayList<Condicion>) conNI.listarTodos(context);
        arrayAdapter = new ArrayAdapter<Condicion>(context, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, listaCondicion);
        spCondicion = findViewById(R.id.spCondicion_perfil);
        spCondicion.setAdapter(arrayAdapter);
        swEditar = findViewById(R.id.swEditar_perfil);
        btnConfirmar = findViewById(R.id.btnConfirmar_perfil);
        sharedpreferences = getSharedPreferences("shared_login_data",   Context.MODE_PRIVATE);
        usuNI.listarUno(sharedpreferences.getInt(login.DNI_CLIENT,0),context);
        int dni = sharedpreferences.getInt(login.DNI_CLIENT,0);
        txtDni.setText(Integer.toString(usuNI.listarUno(dni, context).getDni()));
        txtNombre.setText(usuNI.listarUno(dni, context).getNombre());
        txtApellido.setText(usuNI.listarUno(dni, context).getApellido());
        txtDireccion.setText(usuNI.listarUno(dni, context).getDireccion());
        txtCiudad.setText(usuNI.listarUno(dni, context).getCiudad());
        txtTelefono.setText(usuNI.listarUno(dni, context).getTelefono());
        txtEmail.setText(usuNI.listarUno(dni, context).getEmail());
        txtUsuario.setText(usuNI.listarUno(dni, context).getUsuario());
        txtClave.setText(usuNI.listarUno(dni, context).getClave());
        txtDescripcion.setText(usuNI.listarUno(dni, context).getDescripcion());
        txtEstado.setText(Boolean.toString(usuNI.listarUno(dni, context).getEstado()));
        spCondicion.setSelection(usuNI.listarUno(dni, context).getCondicion().getCodCondicion() - 1);
        // SWITCH EDICION
        onOffEdicion(swEditar.isChecked());
        swEditar.setOnCheckedChangeListener((buttonView, isChecked) -> {
            onOffEdicion(swEditar.isChecked());
        });
        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("BOTON CONFORMAR!!!!",conNI.listarUno(2,context).getDescripcion());
                Usuario usuario = new Usuario(
                    Integer.parseInt(txtDni.getText().toString()),
                    txtNombre.getText().toString(),
                    txtApellido.getText().toString(),
                    txtDireccion.getText().toString(),
                    txtCiudad.getText().toString(),
                    txtTelefono.getText().toString(),
                    txtEmail.getText().toString(),
                    txtUsuario.getText().toString(),
                    txtClave.getText().toString(),
                    txtDescripcion.getText().toString(),
                    txtEstado.getText().toString().equals("true"),
                    conNI.listarUno(spCondicion.getSelectedItemPosition() + 1,context)
                );
                usuNI.editar(usuario,context);
                reload();
            }
        });
    }
    private void onOffEdicion(boolean opcion) {
        txtNombre.setEnabled(opcion);
        txtApellido.setEnabled(opcion);
        txtDireccion.setEnabled(opcion);
        txtCiudad.setEnabled(opcion);
        txtTelefono.setEnabled(opcion);
        txtEmail.setEnabled(opcion);
        txtUsuario.setEnabled(opcion);
        txtClave.setEnabled(opcion);
        txtDescripcion.setEnabled(opcion);
        txtEstado.setEnabled(opcion);
        if (usuNI.listarUno(sharedpreferences.getInt(login.DNI_CLIENT, 0), context).getCondicion().getDescripcion().equals("Administrador")) {
            spCondicion.setEnabled(opcion);
        } else {
            spCondicion.setEnabled(false);
        }
        btnConfirmar.setEnabled(opcion);
    }
    private void reload(){
        Intent i = new Intent(this, PerfilActivity.class);
        startActivity(i);
    }
}