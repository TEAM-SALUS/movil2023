package com.example.salus.negocioImpl;

import android.content.Context;

import com.example.salus.datos.ITurnoDao;
import com.example.salus.datosImpl.TurnoDaoImpl;
import com.example.salus.entidad.Turno;
import com.example.salus.negocio.ITurnoNeg;

import java.util.List;

public class TurnoNegImpl implements ITurnoNeg {
    private ITurnoDao turDao = new TurnoDaoImpl();
    @Override
    public List<Turno> listarTodos(Context context) {
        return turDao.obtenerTodos(context);
    }
    @Override
    public Turno listarUno(int id, Context context) {
        return turDao.obtenerUno(id, context);
    }
    @Override
    public boolean insertar(Turno turno, Context context) {
        return turDao.insertar(turno, context);
    }
    @Override
    public boolean editar(Turno turno, Context context) {
        return turDao.editar(turno, context);
    }
    @Override
    public boolean borrar(int id, Context context) {
        return turDao.borrar(id, context);
    }
}
