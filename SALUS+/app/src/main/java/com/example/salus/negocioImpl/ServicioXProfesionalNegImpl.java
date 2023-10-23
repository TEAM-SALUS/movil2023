package com.example.salus.negocioImpl;

import android.content.Context;

import com.example.salus.datos.IServicioXProfesionalDao;
import com.example.salus.datosImpl.ServicioXProfesionalDaoImpl;
import com.example.salus.entidad.ServicioXProfesional;
import com.example.salus.negocio.IServicioXProfesionalNeg;

import java.util.List;

public class ServicioXProfesionalNegImpl implements IServicioXProfesionalNeg {
    private IServicioXProfesionalDao serXProDao = new ServicioXProfesionalDaoImpl();

    public ServicioXProfesionalNegImpl() {}
    public ServicioXProfesionalNegImpl(IServicioXProfesionalDao serXProDao) {
        this.serXProDao = serXProDao;
    }
    @Override
    public List<ServicioXProfesional> listarTodos(Context context) {
        return serXProDao.obtenerTodos(context);
    }
    @Override
    public ServicioXProfesional listarUno(int idS, int idP, Context context) {
        return serXProDao.obtenerUno(idS, idP, context);
    }
    @Override
    public boolean insertar(ServicioXProfesional servicioXProfesional, Context context) {
        return serXProDao.insertar(servicioXProfesional, context);
    }
    @Override
    public boolean editar(ServicioXProfesional servicioXProfesional, Context context) {
        return serXProDao.editar(servicioXProfesional, context);
    }
    @Override
    public boolean borrar(int idS, int idP, Context context) {
        return serXProDao.borrar(idS, idP, context);
    }
}
