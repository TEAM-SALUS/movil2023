package com.example.salus.datos;

import android.content.Context;

import com.example.salus.entidad.Servicio;

import java.util.List;

public interface IServicioDao {
    public List<Servicio> obtenerTodos(Context context);
    public Servicio obtenerUno(int id, Context context);
    public boolean insertar(Servicio servicio, Context context);
    public boolean editar(Servicio servicio, Context context);
    public boolean borrar(int id, Context context);
}
