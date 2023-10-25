package com.example.salus.datos;

import android.content.Context;

import com.example.salus.entidad.ServicioXProfesional;

import java.util.List;

public interface IServicioXProfesionalDao {
    public List<ServicioXProfesional> obtenerTodos(Context context);
    public ServicioXProfesional obtenerUno(int idS, int idP, Context context);
    public boolean insertar(ServicioXProfesional servicioXProfesional, Context context);
    public boolean editar(ServicioXProfesional servicioXProfesional, Context context);
    public boolean borrar(int idS, int idP, Context context);
}
