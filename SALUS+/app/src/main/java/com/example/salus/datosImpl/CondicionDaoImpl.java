package com.example.salus.datosImpl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.salus.datos.ICondicionDao;
import com.example.salus.entidad.Condicion;

import java.util.ArrayList;
import java.util.List;

public class CondicionDaoImpl implements ICondicionDao {
    private SQLiteDatabase cn;
    @Override
    public List<Condicion> obtenerTodos(Context context) {
        List<Condicion> lista = new ArrayList<Condicion>();
        try {
            cn = new ConexionSQLiteHelper(context).getReadableDatabase();
            Cursor c = cn.rawQuery("SELECT CodCondicion_Con, Descripcion_Con FROM Condicion;",null);
            if(c.moveToFirst()) {
                do {
                    Condicion con = new Condicion();
                    con.setCodCondicion(c.getInt(0));
                    con.setDescripcion(c.getString(1));
                    lista.add(con);
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
    public Condicion obtenerUno(int id, Context context) {
        Condicion con = new Condicion();
        try {
            cn = new ConexionSQLiteHelper(context).getReadableDatabase();
            Cursor c = cn.rawQuery("SELECT CodCondicion_Con, Descripcion_Con " +
                    "FROM Condicion WHERE CodCondicion_Con = " + id + ";",null);
            if(c.moveToFirst()) {
                do {
                    con.setCodCondicion(c.getInt(0));
                    con.setDescripcion(c.getString(1));
                } while (c.moveToNext());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cn.close();
        }
        return con;
    }
    @Override
    public boolean insertar(Condicion condicion, Context context) {
        boolean insert = true;
        try {
            cn = new ConexionSQLiteHelper(context).getWritableDatabase();
            /*
            cn.execSQL("INSERT INTO Condicion (Descripcion_Con) " +
                    "VALUES ('" + condicion.getDescripcion() + "');");
            */
            ContentValues nuevoRegistro = new ContentValues();
            nuevoRegistro.put("CodCondicion_Con",condicion.getCodCondicion());
            nuevoRegistro.put("Descripcion_Con",condicion.getDescripcion());
            cn.insert("Condicion",null,nuevoRegistro);
        } catch (Exception e) {
            e.printStackTrace();
            insert = false;
        } finally {
            cn.close();
        }
        return insert;
    }
    @Override
    public boolean editar(Condicion condicion, Context context) {
        boolean update = true;
        try {
            cn = new ConexionSQLiteHelper(context).getWritableDatabase();
            /*
            cn.execSQL("UPDATE Condicion SET Descripcion_Con = '"+ condicion.getDescripcion()
                    +"' WHERE CodCondicion_Con = '" + condicion.getCodCondicion() + "');");
            */
            ContentValues nuevoRegistro = new ContentValues();
            nuevoRegistro.put("Descripcion_Con",condicion.getDescripcion());
            cn.update("Condicion",nuevoRegistro,"CodCondicion_Con = " +
                    Integer.toString(condicion.getCodCondicion()),null);
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
            cn.execSQL("DELETE FROM Condicion WHERE CodCondicion_Con = " + id + ";");
            */
            cn.delete("Condicion","CodCondicion_Con = " + id,null);
        } catch (Exception e) {
            e.printStackTrace();
            delete = false;
        } finally {
            cn.close();
        }
        return delete;
    }
}
