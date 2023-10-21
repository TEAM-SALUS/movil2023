package com.example.salus.datos;

import android.content.Context;

import com.example.salus.entidad.Categoria;

import java.util.List;

public interface ICategoriaDao {
    public List<Categoria> obtenerTodos(Context context);
    public Categoria obtenerUno(int id, Context context);
    public boolean insertar(Categoria categoria, Context context);
    public boolean editar(Categoria categoria, Context context);
    public boolean borrar(int id, Context context);
}
