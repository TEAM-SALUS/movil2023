package com.example.salus.negocioImpl;

import android.content.Context;

import com.example.salus.datos.ICondicionDao;
import com.example.salus.datosImpl.CondicionDaoImpl;
import com.example.salus.entidad.Condicion;
import com.example.salus.negocio.ICondicionNeg;

import java.util.List;

public class CondicionNegImpl implements ICondicionNeg {
    private ICondicionDao conDao = new CondicionDaoImpl();

    public CondicionNegImpl() {}
    public CondicionNegImpl(ICondicionDao conDao) { this.conDao = conDao; }
    @Override
    public List<Condicion> listarTodos(Context context) {
        return conDao.obtenerTodos(context);
    }
    @Override
    public Condicion listarUno(int id, Context context) {
        return conDao.obtenerUno(id,context);
    }
    @Override
    public boolean insertar(Condicion condicion, Context context) {
        return conDao.insertar(condicion,context);
    }
    @Override
    public boolean editar(Condicion condicion, Context context) {
        return conDao.editar(condicion,context);
    }
    @Override
    public boolean borrar(int id, Context context) {
        return conDao.borrar(id,context);
    }
}
