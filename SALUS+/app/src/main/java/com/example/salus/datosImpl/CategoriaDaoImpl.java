package com.example.salus.datosImpl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.salus.datos.ICategoriaDao;
import com.example.salus.entidad.Categoria;

import java.util.ArrayList;
import java.util.List;

public class CategoriaDaoImpl implements ICategoriaDao {
    private SQLiteDatabase cn;
    @Override
    public List<Categoria> obtenerTodos(Context context) {
        List<Categoria> lista = new ArrayList<Categoria>();
        try {
            cn = new ConexionSQLiteHelper(context).getReadableDatabase();
            Cursor c = cn.rawQuery("SELECT CodCategoria_Cat, Descripcion_Cat FROM Categoria;",null);
            if(c.moveToFirst()) {
                do {
                    Categoria cat = new Categoria();
                    cat.setCodCategoria(c.getInt(0));
                    cat.setDescripcion(c.getString(1));
                    lista.add(cat);
                } while (c.moveToNext());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
          cn.close();
        }
        return lista;
    }
    @Override
    public Categoria obtenerUno(int id, Context context) {
        Categoria cat = new Categoria();
        try {
            cn = new ConexionSQLiteHelper(context).getReadableDatabase();
            Cursor c = cn.rawQuery("SELECT CodCategoria_Cat, Descripcion_Cat " +
                    "FROM Categoria WHERE CodCategoria_Cat = " + id + ";",null);
            if(c.moveToFirst()) {
                do {
                    cat.setCodCategoria(c.getInt(0));
                    cat.setDescripcion(c.getString(1));
                } while (c.moveToNext());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cn.close();
        }
        return cat;
    }
    @Override
    public boolean insertar(Categoria categoria, Context context) {
        boolean insert = true;
        try {
            cn = new ConexionSQLiteHelper(context).getWritableDatabase();
            /*
            cn.execSQL("INSERT INTO Categoria (Descripcion_Cat) " +
                    "VALUES ('" + categoria.getDescripcion() + "');");
            */
            ContentValues nuevoRegistro = new ContentValues();
            nuevoRegistro.put("CodCategoria_Cat",categoria.getCodCategoria());
            nuevoRegistro.put("Descripcion_Cat",categoria.getDescripcion());
            cn.insert("Categoria",null,nuevoRegistro);
        } catch (Exception e) {
            e.printStackTrace();
            insert = false;
        } finally {
            cn.close();
        }
        return insert;
    }
    @Override
    public boolean editar(Categoria categoria, Context context) {
        boolean update = true;
        try {
            cn = new ConexionSQLiteHelper(context).getWritableDatabase();
            /*
            cn.execSQL("UPDATE Categoria SET Descripcion_Cat = '"+ categoria.getDescripcion()
                    +"' WHERE CodCategoria_Cat = '" + categoria.getCodCategoria() + "');");
            */
            ContentValues nuevoRegistro = new ContentValues();
            nuevoRegistro.put("Descripcion_Cat",categoria.getDescripcion());
            cn.update("Categoria",nuevoRegistro,"CodCategoria_Cat = " +
                    Integer.toString(categoria.getCodCategoria()),null);
        } catch (Exception e) {
            e.printStackTrace();
            update = false;
        } finally {
            cn.close();
        }
        return update;
    }
    @Override
    public boolean borrar(int id, Context context) {
        boolean delete = true;
        try {
            cn = new ConexionSQLiteHelper(context).getWritableDatabase();
            /*
            cn.execSQL("DELETE FROM Categoria WHERE CodCategoria_Cat = " + id + ";");
            */
            cn.delete("Categoria","CodCategoria_Cat = " + id,null);
        } catch (Exception e) {
            e.printStackTrace();
            delete = false;
        } finally {
            cn.close();
        }
        return delete;
    }
}
