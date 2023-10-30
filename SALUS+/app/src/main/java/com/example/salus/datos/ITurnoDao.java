package com.example.salus.datos;

import android.content.Context;

import com.example.salus.entidad.Categoria;
import com.example.salus.entidad.Turno;

import java.util.List;

public interface ITurnoDao {
    public List<Turno> obtenerTodos(Context context);
    public Turno obtenerUno(int id, Context context);
    public boolean insertar(Turno turno, Context context);
    public boolean editar(Turno turno, Context context);
    public boolean borrar(int id, Context context);
}
