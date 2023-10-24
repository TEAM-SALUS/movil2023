package com.example.salus.negocio;

import android.content.Context;

import com.example.salus.entidad.Servicio;

import java.util.List;

public interface IServicioNeg {
    public List<Servicio> listarTodos(Context context);
    public Servicio listarUno(int id, Context context);
    public boolean insertar(Servicio servicio, Context context);
    public boolean editar(Servicio servicio, Context context);
    public boolean borrar(int id, Context context);
}

