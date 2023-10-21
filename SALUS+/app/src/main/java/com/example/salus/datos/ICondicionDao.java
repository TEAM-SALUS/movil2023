package com.example.salus.datos;

import android.content.Context;

import com.example.salus.entidad.Condicion;

import java.util.List;

public interface ICondicionDao {
    public List<Condicion> obtenerTodos(Context context);
    public Condicion obtenerUno(int id, Context context);
    public boolean insertar(Condicion condicion, Context context);
    public boolean editar(Condicion condicion, Context context);
    public boolean borrar(int id, Context context);
}
