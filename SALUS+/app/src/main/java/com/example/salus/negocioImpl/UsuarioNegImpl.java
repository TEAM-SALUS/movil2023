package com.example.salus.negocioImpl;

import android.content.Context;

import com.example.salus.datos.IUsuarioDao;
import com.example.salus.datosImpl.UsuarioDaoImpl;
import com.example.salus.entidad.Usuario;
import com.example.salus.negocio.IUsuarioNeg;

import java.util.List;

public class UsuarioNegImpl implements IUsuarioNeg {
    private IUsuarioDao usuDao = new UsuarioDaoImpl();
    public UsuarioNegImpl() {}
    public UsuarioNegImpl(IUsuarioDao usuDao) {
        this.usuDao = usuDao;
    }
    @Override
    public List<Usuario> listarTodos(Context context) {
        return usuDao.obtenerTodos(context);
    }
    @Override
    public Usuario listarUno(int id,Context context) {
        return usuDao.obtenerUno(id, context);
    }
    @Override
    public boolean insertar(Usuario usuario, Context context) {
        return usuDao.insertar(usuario, context);
    }
    @Override
    public boolean editar(Usuario usuario, Context context) {
        return usuDao.editar(usuario, context);
    }
    @Override
    public boolean borrar(int id, Context context) {
        return usuDao.borrar(id, context);
    }
    @Override
    public Usuario login(String email, String pass, Context context){
        return usuDao.login(email, pass, context);
    }
}
