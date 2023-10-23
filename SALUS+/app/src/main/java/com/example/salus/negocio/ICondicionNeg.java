package com.example.salus.negocio;

import android.content.Context;

import com.example.salus.entidad.Condicion;

import java.util.List;

public interface ICondicionNeg {
    public List<Condicion> listarTodos(Context context);
    public Condicion listarUno(int id, Context context);
    public boolean insertar(Condicion condicion, Context context);
    public boolean editar(Condicion condicion, Context context);
    public boolean borrar(int id, Context context);
}
