package com.example.salus;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.salus.entidad.Categoria;
import com.example.salus.entidad.Servicio;
import com.example.salus.entidad.ServicioXProfesional;
import com.example.salus.entidad.Usuario;
import com.example.salus.negocio.ICategoriaNeg;
import com.example.salus.negocio.IServicioXProfesionalNeg;
import com.example.salus.negocio.IUsuarioNeg;
import com.example.salus.negocioImpl.CategoriaNegImpl;
import com.example.salus.negocioImpl.ServicioXProfesionalNegImpl;
import com.example.salus.negocioImpl.UsuarioNegImpl;

import java.util.ArrayList;
import java.util.List;


public class ProfesionalActivity extends AppCompatActivity {
    private Context context;
    private ICategoriaNeg catNI;
    private IUsuarioNeg usuNI;
    private IServicioXProfesionalNeg serXProNI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profesional);

        usuNI = new UsuarioNegImpl();
        catNI = new CategoriaNegImpl();
        context = getApplicationContext();
        serXProNI = new ServicioXProfesionalNegImpl();

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        Log.d("Que me mandaste ",extras.get("proSeleccionado").toString());
        Log.d("Que me mandaste ",extras.get("especialidadSeleccionada").toString());
        Integer value = null;
        Integer value2 = null;
        value = Integer.parseInt(extras.get("proSeleccionado").toString());
        value2 = Integer.parseInt(extras.get("especialidadSeleccionada").toString());
        if (extras.get("proSeleccionado") != null && value != 0) {
            Log.d("Obteniendo datos ","del usuario");
            Usuario usuario = usuNI.listarUno(value, context);
            TextView mTextViewName = (TextView)this.findViewById(R.id.prTitulo);
            mTextViewName.setText(usuario.getNombre().toString() + " " + usuario.getApellido().toString());
            TextView mTextViewDesc = (TextView)this.findViewById(R.id.prDescripcion);
            mTextViewDesc.setText(usuario.getDescripcion().toString());

            List<ServicioXProfesional> lista = (ArrayList<ServicioXProfesional>)serXProNI.listarTodos(context);
            String serviciosValue = "";
            for(int indice = 0;indice<lista.size();indice++) {
                serviciosValue += lista.get(indice).getServicio_SXP().getTitulo().toString() + '\n';
            }
            TextView mTextViewSer = (TextView)this.findViewById(R.id.prEspecialidades);
            mTextViewSer.setText(serviciosValue);
        }
        if (extras.get("especialidadSeleccionada") != null && value2 != 0) {
            Log.d("Obteniendo datos ","de la categoria");
            Categoria categoria = catNI.listarUno(value2, context);
            TextView mTextViewCat = (TextView)this.findViewById(R.id.prEspecialidad);
            mTextViewCat.setText(categoria.getDescripcion().toString());
        }

    }

}
