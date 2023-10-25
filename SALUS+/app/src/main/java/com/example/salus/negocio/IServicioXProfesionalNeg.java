package com.example.salus.negocio;

import android.content.Context;

import com.example.salus.entidad.ServicioXProfesional;

import java.util.List;

public interface IServicioXProfesionalNeg {
    public List<ServicioXProfesional> listarTodos(Context context);
    public ServicioXProfesional listarUno(int idS, int idP, Context context);
    public boolean insertar(ServicioXProfesional servicioXProfesional, Context context);
    public boolean editar(ServicioXProfesional servicioXProfesional, Context context);
    public boolean borrar(int idS, int idP, Context context);
}
