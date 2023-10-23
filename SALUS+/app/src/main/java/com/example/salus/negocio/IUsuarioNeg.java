package com.example.salus.negocio;

import android.content.Context;

import com.example.salus.entidad.Usuario;

import java.util.List;

public interface IUsuarioNeg {
    public List<Usuario> listarTodos(Context context);
    public Usuario listarUno(int id, Context context);
    public boolean insertar(Usuario usuario, Context context);
    public boolean editar(Usuario usuario, Context context);
    public boolean borrar(int id, Context context);
}
