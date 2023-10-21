package com.example.salus.negocio;

import android.content.Context;

import com.example.salus.entidad.Categoria;
import com.example.salus.entidad.Turno;

import java.util.List;

public interface ITurnoNeg {
    public List<Turno> listarTodos(Context context);
    public Turno listarUno(int id, Context context);
    public boolean insertar(Turno turno, Context context);
    public boolean editar(Turno turno, Context context);
    public boolean borrar(int id, Context context);
}
