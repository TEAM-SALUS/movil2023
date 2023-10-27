package com.example.salus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.salus.adaptador.ProfesionalesAdaptador;
import com.example.salus.entidad.Categoria;
import com.example.salus.entidad.Condicion;
import com.example.salus.entidad.Servicio;
import com.example.salus.entidad.ServicioXProfesional;
import com.example.salus.entidad.Turno;
import com.example.salus.entidad.Usuario;
import com.example.salus.negocio.ICategoriaNeg;
import com.example.salus.negocio.ICondicionNeg;
import com.example.salus.negocio.IServicioNeg;
import com.example.salus.negocio.IServicioXProfesionalNeg;
import com.example.salus.negocio.ITurnoNeg;
import com.example.salus.negocio.IUsuarioNeg;
import com.example.salus.negocioImpl.CategoriaNegImpl;
import com.example.salus.negocioImpl.CondicionNegImpl;
import com.example.salus.negocioImpl.ServicioNegImpl;
import com.example.salus.negocioImpl.ServicioXProfesionalNegImpl;
import com.example.salus.negocioImpl.TurnoNegImpl;
import com.example.salus.negocioImpl.UsuarioNegImpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ProfesionalesActivity extends AppCompatActivity {
    private Context context;
    private ICategoriaNeg catNI;
    private ICondicionNeg conNI;
    private IServicioNeg serNI;
    private IUsuarioNeg usuNI;
    private IServicioXProfesionalNeg serXProNI;
    private ITurnoNeg turNI;
    private RecyclerView recyclerServicioXPreofesional;
    private ProfesionalesAdaptador profesionalesAdaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profesionales);
        iniciar();
    }
    private void iniciar() {
        context = getApplicationContext();
        catNI = new CategoriaNegImpl();
        conNI = new CondicionNegImpl();
        serNI = new ServicioNegImpl();
        usuNI = new UsuarioNegImpl();
        serXProNI = new ServicioXProfesionalNegImpl();
        turNI = new TurnoNegImpl();
        recyclerServicioXPreofesional = findViewById(R.id.recyclerProfesionales);
        recyclerServicioXPreofesional.setLayoutManager(new LinearLayoutManager(context));
        profesionalesAdaptador = new ProfesionalesAdaptador(serXProNI.listarTodos(context),context);
        recyclerServicioXPreofesional.setAdapter(profesionalesAdaptador);
        listarCategoria();
        //listarCategoriaId();
        //actualizarCategoria();
        //eliminarCategoria();
        listarCondicion();
        //listarCondicionId();
        //actualizarCondicion();
        //eliminarCondicion();
        listarServicio();
        //listarServicioId();
        //actualizarServicio();
        //eliminarServicio();
        listarUsuario();
        //listarUsuarioId();
        //actualizarUsuario();
        //eliminarUsuario();
        listarServicioXProfesional();
        //listarServicioXProfesionalId();
        //actualizarServicioXProfesional();
        //eliminarServicioXProfesional();
        //listarTurno();
        //listarTurnoId();
        //actualizarTurno();
        //eliminarTurno();
    }
    public void irProfesional(View view) {
        Intent intent = new Intent(this, ProfesionalActivity.class);
        startActivity(intent);
    }
    /* TEST Categoria */
    public void listarCategoria() {
        List<Categoria> lista = (ArrayList<Categoria>)catNI.listarTodos(context);
        if(lista.size() == 0) {
            catNI.insertar(new Categoria(1,"Odontologia"), context);
            catNI.insertar(new Categoria(2,"Neurologia"), context);
            catNI.insertar(new Categoria(3,"Psiquiatria"), context);
        }
        String listaTxt = "";
        for (Categoria c : lista) {
            listaTxt += c.toString() + "\n";
            Log.d("Categoria ",c.toString());
        }
        Toast.makeText(context,"Listado categorias",Toast.LENGTH_LONG).show();
        Log.d("Lista Categoria ",listaTxt);
    }
    public void listarCategoriaId(){
        Log.d("Categoria id 1", catNI.listarUno(1, context).toString());
    }
    public void actualizarCategoria(){
        Categoria c = new Categoria(1,"Nueva descripcion1");
        Log.d("Categoria id 1 - descrpcion nueva", catNI.listarUno(1, context).toString());
        Log.d("Categoria id 1 - descrpcion nueva", String.valueOf(catNI.editar(c, context)));
        Log.d("Categoria id 1 - descrpcion nueva", catNI.listarUno(1, context).toString());
        c = new Categoria(1,"Odontologia");
        catNI.editar(c, context);
        Log.d("Categoria id 1 - descrpcion final", catNI.listarUno(1, context).toString());
    }
    public void eliminarCategoria() {
        catNI.insertar(new Categoria(4,"Cuarta Ctaegoria"), context);
        Log.d("Categoria 4 agregada ", catNI.listarUno(4,context).toString());
        Log.d("Categoria 4 elimianda ",String.valueOf(catNI.borrar(4, context)));
        Log.d("Categoria 4 agregada ", catNI.listarUno(4,context).toString());
    }
    /* TEST Condicion */
    public void listarCondicion() {
        List<Condicion> lista = (ArrayList<Condicion>)conNI.listarTodos(context);
        if(lista.size() == 0) {
            conNI.insertar(new Condicion(1,"Paciente"), context);
            conNI.insertar(new Condicion(2,"Profesional"), context);
            conNI.insertar(new Condicion(3,"Administrador"), context);
        }
        String listaTxt = "";
        for (Condicion c : lista) {
            listaTxt += c.toString() + "\n";
            Log.d("Condicion ",c.toString());
        }
        Toast.makeText(context,"Listado condiciones",Toast.LENGTH_LONG).show();
        Log.d("Lista Condicion ",listaTxt);
    }
    public void listarCondicionId(){
        Log.d("Condicion id 1", conNI.listarUno(1, context).toString());
    }
    public void actualizarCondicion(){
        Condicion c = new Condicion(1,"Nueva descripcion1");
        Log.d("Condicion id 1 - descrpcion nueva", conNI.listarUno(1, context).toString());
        Log.d("Condicion id 1 - descrpcion nueva", String.valueOf(conNI.editar(c, context)));
        Log.d("Condicion id 1 - descrpcion nueva", conNI.listarUno(1, context).toString());
        c = new Condicion(1,"Paciente");
        conNI.editar(c, context);
        Log.d("Categoria id 1 - descrpcion final", conNI.listarUno(1, context).toString());
    }
    public void eliminarCondicion() {
        conNI.insertar(new Condicion(4,"Cuarta Condicion"), context);
        Log.d("Condicion 4 agregada ", conNI.listarUno(4,context).toString());
        Log.d("Condicion 4 elimianda ",String.valueOf(conNI.borrar(4, context)));
        Log.d("Condicion 4 agregada ", conNI.listarUno(4,context).toString());
    }
    /* TEST Servicio */
    public void listarServicio() {
        List<Servicio> lista = (ArrayList<Servicio>)serNI.listarTodos(context);
        if(lista.size() == 0) {
            serNI.insertar(new Servicio(1, "Tratamiento Conducto", "Se mata nervios de dientes", true,catNI.listarUno(1, context)), context);
            serNI.insertar(new Servicio(2, "Examen Electrocenografia", "Se revisa el cerebro", true,catNI.listarUno(2, context)), context);
            serNI.insertar(new Servicio(3, "Entrevista Psiquiatrica", "Se revisa salud mental", true,catNI.listarUno(3, context)), context);
        }
        String listaTxt = "";
        for (Servicio s : lista) {
            listaTxt += s.toString() + "\n";
            Log.d("Servicio ",s.toString());
        }
        Toast.makeText(context,"Listado servicios",Toast.LENGTH_LONG).show();
        Log.d("Lista Servicio ",listaTxt);
    }
    public void listarServicioId(){
        Log.d("Servicio id 1", serNI.listarUno(1, context).toString());
    }
    public void actualizarServicio(){
        Servicio s = new Servicio(1, "Titulo Nuevo", "Descripcion nueva", true,catNI.listarUno(1, context));
        Log.d("Servicio id 1 - descrpcion nueva", serNI.listarUno(1, context).toString());
        Log.d("Servicio id 1 - descrpcion nueva", String.valueOf(serNI.editar(s, context)));
        Log.d("Servicio id 1 - descrpcion nueva", serNI.listarUno(1, context).toString());
        s = new Servicio(1, "Tratamiento Conducto", "Se mata nervios de dientes", true,catNI.listarUno(1, context));
        serNI.editar(s, context);
        Log.d("Servicio id 1 - descrpcion final", serNI.listarUno(1, context).toString());
    }
    public void eliminarServicio() {
        serNI.insertar( new Servicio(4, "Titulo 4", "Descripcion 4", true,catNI.listarUno(1, context)), context);
        Log.d("Servicio 4 agregada ", serNI.listarUno(4,context).toString());
        Log.d("Servicio 4 elimianda ",String.valueOf(serNI.borrar(4, context)));
        Log.d("Servicio 4 agregada ", serNI.listarUno(4,context).toString());
    }
    /* TEST Usuario */
    public void listarUsuario() {
        List<Usuario> lista = (ArrayList<Usuario>)usuNI.listarTodos(context);
        if(lista.size() == 0) {
            usuNI.insertar(new Usuario(11111111, "Nombre Uno", "Apellido Uno", "Direccion 1", "Ciudad 1", "Telefono 1","Email 1","Usuario 1","Clave 1", true,conNI.listarUno(1, context)), context);
            usuNI.insertar(new Usuario(22222222, "Nombre Dos", "Apellido Dos", "Direccion 2", "Ciudad 2", "Telefono 2","Email 2", "Usuario 2", "Clave 2" ,true,conNI.listarUno(2, context)), context);
            usuNI.insertar(new Usuario(0, "Nombre Admin", "Apellido Admin", "Direccion Admin", "Ciudad Admin", "Telefono Admin","Email admin","Usuario admin", "Clave 3",true,conNI.listarUno(3, context)), context);
        }
        String listaTxt = "";
        for (Usuario u : lista) {
            listaTxt += u.toString() + "\n";
            Log.d("Usuario ",u.toString());
        }
        Toast.makeText(context,"Listado usuarios",Toast.LENGTH_LONG).show();
        Log.d("Lista Usuario ",listaTxt);
    }
    public void listarUsuarioId(){
        Usuario u = usuNI.listarUno(11111111, context);
        Log.d("Usuario id 1", u.toString());
        if(u.getDni() == 0){
            Toast.makeText(context,"Usuario no registrado",Toast.LENGTH_LONG).show();
        }
    }
    public void actualizarUsuario(){
        Usuario u = new Usuario(11111111, "Nombre Nuevo", "Apellido Nuevo", "Direccion Nuevo", "Ciudad Nuevo", "Telefono Nuevo","Email nuevo", "Usuario nuevo","Clave nueva", true,conNI.listarUno(1, context));
        Log.d("Usuario id 11111111 - descrpcion nueva", usuNI.listarUno(11111111, context).toString());
        Log.d("Usuario id 11111111 - descrpcion nueva", String.valueOf(usuNI.editar(u, context)));
        Log.d("Usuario id 11111111 - descrpcion nueva", usuNI.listarUno(11111111, context).toString());
        u = new Usuario(11111111, "Nombre Uno", "Apellido Uno", "Direccion 1", "Ciudad 1", "Telefono 1", "Email 1", "Usuario 1","Clave 1", true,conNI.listarUno(1, context));
        usuNI.editar(u, context);
        Log.d("Usuario id 11111111 - descrpcion final", usuNI.listarUno(11111111, context).toString());
    }
    public void eliminarUsuario() {
        usuNI.insertar( new Usuario(444444444, "Nombre Cuatro", "Apellido Cuatro", "Direccion 4", "Ciudad 4", "Telefono 4","Email 4","Usuario 4","Clave 4", true,conNI.listarUno(1, context)), context);
        Log.d("Usuario 444444444 agregada ", usuNI.listarUno(444444444,context).toString());
        Log.d("Usuario 444444444 elimianda ",String.valueOf(usuNI.borrar(444444444, context)));
        Log.d("Usuario 444444444 agregada ", usuNI.listarUno(444444444,context).toString());
    }
    /* TEST ServicioXProfesional */
    public void listarServicioXProfesional() {
        List<ServicioXProfesional> lista = (ArrayList<ServicioXProfesional>)serXProNI.listarTodos(context);
        if(lista.size() == 0) {
            serXProNI.insertar(new ServicioXProfesional(serNI.listarUno(1,context),usuNI.listarUno(22222222,context)), context);
            serXProNI.insertar(new ServicioXProfesional(serNI.listarUno(2,context),usuNI.listarUno(22222222,context)), context);
            serXProNI.insertar(new ServicioXProfesional(serNI.listarUno(3,context),usuNI.listarUno(22222222,context)), context);
        }
        String listaTxt = "";
        for (ServicioXProfesional sXP : lista) {
            listaTxt += sXP.toString() + "\n";
            Log.d("ServicioXProfesional ",sXP.toString());
        }
        Toast.makeText(context,"Listado servicioXProfesional",Toast.LENGTH_LONG).show();
        Log.d("Lista ServicioXProfesional ",listaTxt);
    }
    public void listarServicioXProfesionalId(){
        ServicioXProfesional sXP = serXProNI.listarUno(1,22222222, context);
        Log.d("ServicioXProfesional idS 1 - idP 22222222", sXP.toString());
        if(((Usuario)sXP.getUsuario_SXP()).getDni() == 0){
            Toast.makeText(context,"ServicioXProfesional no registrado",Toast.LENGTH_LONG).show();
        }
    }
    public void actualizarServicioXProfesional(){
        ServicioXProfesional sXP = new ServicioXProfesional(serNI.listarUno(1,context),usuNI.listarUno(22222222,context));
        Log.d("ServicioXProfesional idS 1 - descrpcion nueva", serXProNI.listarUno(1,22222222, context).toString());
        Log.d("ServicioXProfesional idS 1 - descrpcion nueva", String.valueOf(serXProNI.editar(sXP, context)));
        Log.d("ServicioXProfesional idS 1 - descrpcion nueva", serXProNI.listarUno(1, 22222222, context).toString());
        sXP = new ServicioXProfesional(serNI.listarUno(1,context),usuNI.listarUno(22222222,context));
        serXProNI.editar(sXP, context);
        Log.d("ServicioXProfesional idS 1 - idP 22222222 - descrpcion final", serXProNI.listarUno(1, 22222222, context).toString());
    }
    public void eliminarServicioXProfesional() {
        serXProNI.insertar(
                new ServicioXProfesional(
                        serNI.listarUno(1,context),
                        usuNI.listarUno(11111111,context)),
                context);
        Log.d("ServicioXProfesional 11111111 agregada ", serXProNI.listarUno(1,11111111,context).toString());
        Log.d("ServicioXProfesional 11111111 elimianda ",String.valueOf(serXProNI.borrar(1,11111111, context)));
        Log.d("ServicioXProfesional 11111111 agregada ", serXProNI.listarUno(1,11111111,context).toString());
    }
    /* TEST Turno */
    public void listarTurno() {
        List<Turno> lista = (ArrayList<Turno>)turNI.listarTodos(context);
        if(lista.size() == 0) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                turNI.insertar(new Turno(1,LocalDateTime.now(), LocalDateTime.now(), true, usuNI.listarUno(11111111,context), serXProNI.listarUno(1,22222222,context)), context);
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                turNI.insertar(new Turno(2,LocalDateTime.now(), LocalDateTime.now(), true, usuNI.listarUno(11111111,context), serXProNI.listarUno(2,22222222,context)), context);
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                turNI.insertar(new Turno(3,LocalDateTime.now(), LocalDateTime.now(), true, usuNI.listarUno(11111111,context), serXProNI.listarUno(3,22222222,context)), context);
            }
        }
        String listaTxt = "";
        for (Turno t : lista) {
            listaTxt += t.toString() + "\n";
            Log.d("ServicioXProfesional ",t.toString());
        }
        Toast.makeText(context,"Listado servicioXProfesional",Toast.LENGTH_LONG).show();
        Log.d("Lista ServicioXProfesional ",listaTxt);
    }
    public void listarTurnoId(){
        ServicioXProfesional sXP = serXProNI.listarUno(1,22222222, context);
        Log.d("ServicioXProfesional idS 1 - idP 22222222", sXP.toString());
        if(((Usuario)sXP.getUsuario_SXP()).getDni() == 0){
            Toast.makeText(context,"ServicioXProfesional no registrado",Toast.LENGTH_LONG).show();
        }
    }
    public void actualizarTurno(){
        ServicioXProfesional sXP = new ServicioXProfesional(serNI.listarUno(1,context),usuNI.listarUno(22222222,context));
        Log.d("ServicioXProfesional idS 1 - descrpcion nueva", serXProNI.listarUno(1,22222222, context).toString());
        Log.d("ServicioXProfesional idS 1 - descrpcion nueva", String.valueOf(serXProNI.editar(sXP, context)));
        Log.d("ServicioXProfesional idS 1 - descrpcion nueva", serXProNI.listarUno(1, 22222222, context).toString());
        sXP = new ServicioXProfesional(serNI.listarUno(1,context),usuNI.listarUno(22222222,context));
        serXProNI.editar(sXP, context);
        Log.d("ServicioXProfesional idS 1 - idP 22222222 - descrpcion final", serXProNI.listarUno(1, 22222222, context).toString());
    }
    public void eliminarTurno() {
        serXProNI.insertar(
                new ServicioXProfesional(
                        serNI.listarUno(1,context),
                        usuNI.listarUno(11111111,context)),
                context);
        Log.d("ServicioXProfesional 11111111 agregada ", serXProNI.listarUno(1,11111111,context).toString());
        Log.d("ServicioXProfesional 11111111 elimianda ",String.valueOf(serXProNI.borrar(1,11111111, context)));
        Log.d("ServicioXProfesional 11111111 agregada ", serXProNI.listarUno(1,11111111,context).toString());
    }
}