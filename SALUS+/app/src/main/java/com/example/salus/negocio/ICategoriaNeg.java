package com.example.salus.negocio;

import android.content.Context;

import com.example.salus.entidad.Categoria;

import java.util.List;

public interface ICategoriaNeg {
    public List<Categoria> listarTodos(Context context);
    public Categoria listarUno(int id, Context context);
    public boolean insertar(Categoria categoria, Context context);
    public boolean editar(Categoria categoria, Context context);
    public boolean borrar(int id, Context context);
}
