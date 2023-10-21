package com.example.salus.negocioImpl;

import android.content.Context;

import com.example.salus.datos.IServicioDao;
import com.example.salus.datosImpl.ServicioDaoImpl;
import com.example.salus.entidad.Servicio;
import com.example.salus.negocio.IServicioNeg;

import java.util.List;

public class ServicioNegImpl implements IServicioNeg {
    private IServicioDao serDao = new ServicioDaoImpl();

    public ServicioNegImpl() {}
    public ServicioNegImpl(IServicioDao serDao) {
        this.serDao = serDao;
    }
    @Override
    public List<Servicio> listarTodos(Context context) {
        return serDao.obtenerTodos(context);
    }
    @Override
    public Servicio listarUno(int id, Context context) {
        return serDao.obtenerUno(id, context);
    }
    @Override
    public boolean insertar(Servicio servicio, Context context) {
        return serDao.insertar(servicio, context);
    }
    @Override
    public boolean editar(Servicio servicio, Context context) {
        return serDao.editar(servicio, context);
    }
    @Override
    public boolean borrar(int id, Context context) {
        return serDao.borrar(id, context);
    }
}
