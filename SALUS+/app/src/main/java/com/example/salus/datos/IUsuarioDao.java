package com.example.salus.datos;

import android.content.Context;

import com.example.salus.entidad.Usuario;

import java.util.List;

public interface IUsuarioDao {
    public List<Usuario> obtenerTodos(Context context);
    public Usuario obtenerUno(int id, Context context);
    public boolean insertar(Usuario usuario, Context context);
    public boolean editar(Usuario usuario, Context context);
    public boolean borrar(int id, Context context);
    public Usuario login(String email, String pass, Context context);
}
