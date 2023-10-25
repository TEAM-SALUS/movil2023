package com.example.salus.negocioImpl;

import android.content.Context;

import com.example.salus.datos.ICategoriaDao;
import com.example.salus.datosImpl.CategoriaDaoImpl;
import com.example.salus.entidad.Categoria;
import com.example.salus.negocio.ICategoriaNeg;

import java.util.List;

public class CategoriaNegImpl implements ICategoriaNeg {
    private ICategoriaDao catDao = new CategoriaDaoImpl();
    public CategoriaNegImpl() {}
    public CategoriaNegImpl(ICategoriaDao catDao) { this.catDao = catDao; }
    @Override
    public List<Categoria> listarTodos(Context context) {
        return catDao.obtenerTodos(context);
    }
    @Override
    public Categoria listarUno(int id, Context context) { return catDao.obtenerUno(id, context); }
    @Override
    public boolean insertar(Categoria categoria, Context context) {
        return catDao.insertar(categoria, context);
    }
    @Override
    public boolean editar(Categoria categoria, Context context) {
        return catDao.editar(categoria, context);
    }
    @Override
    public boolean borrar(int id, Context context) {
        return catDao.borrar(id, context);
    }
}
