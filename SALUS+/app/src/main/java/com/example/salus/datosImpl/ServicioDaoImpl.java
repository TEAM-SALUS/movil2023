package com.example.salus.datosImpl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.salus.datos.IServicioDao;
import com.example.salus.entidad.Servicio;
import com.example.salus.negocio.ICategoriaNeg;
import com.example.salus.negocioImpl.CategoriaNegImpl;

import java.util.ArrayList;
import java.util.List;

public class ServicioDaoImpl implements IServicioDao {
    private SQLiteDatabase cn;
    private ICategoriaNeg catNI;
    @Override
    public List<Servicio> obtenerTodos(Context context) {
        List<Servicio> lista = new ArrayList<Servicio>();
        try {
            cn = new ConexionSQLiteHelper(context).getReadableDatabase();
            Cursor c = cn.rawQuery("SELECT CodServicio_Ser, Titulo_Ser, Descripcion_Ser," +
                    " Estado, CodCategoria_Ser FROM Servicio;",null);
            if(c.moveToFirst()) {
                catNI = new CategoriaNegImpl();
                do {
                    Servicio ser = new Servicio();
                    ser.setCodServicio(c.getInt(0));
                    ser.setTitulo(c.getString(1));
                    ser.setDescripcion(c.getString(2));
                    ser.setEstado(c.getString(3).equals("1"));
                    Log.d("Estado Servicio ",Boolean.toString(c.getString(3).equals("1")));
                    ser.setCategoria(
                            catNI.listarUno(c.getInt(4), context)
                    );
                    lista.add(ser);
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
    public Servicio obtenerUno(int id, Context context) {
        Servicio ser = new Servicio();
        try {
            cn = new ConexionSQLiteHelper(context).getReadableDatabase();
            Cursor c = cn.rawQuery("SELECT CodServicio_Ser, Titulo_Ser, Descripcion_Ser," +
                    " Estado, CodCategoria_Ser FROM Servicio WHERE CodServicio_Ser = " + id + ";",null);
            if(c.moveToFirst()) {
                catNI = new CategoriaNegImpl();
                do {
                    ser.setCodServicio(c.getInt(0));
                    ser.setTitulo(c.getString(1));
                    ser.setDescripcion(c.getString(2));
                    ser.setEstado((c.getString(3).equals("1")));
                    ser.setCategoria(
                            catNI.listarUno(c.getInt(4), context)
                    );
                } while (c.moveToNext());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cn.close();
        }
        return ser;
    }
    @Override
    public boolean insertar(Servicio servicio, Context context) {
        boolean insert = true;
        try {
            cn = new ConexionSQLiteHelper(context).getWritableDatabase();
            /*
            cn.execSQL("INSERT INTO Servicio (CodServicio_Ser, Titulo_Ser, Descripcion_Ser," +
                    "Estado, CodCategoria_Ser) VALUES ('" + servicio.getDescripcion() + "');");
            */
            ContentValues nuevoRegistro = new ContentValues();
            nuevoRegistro.put("CodServicio_Ser",servicio.getCodServicio());
            nuevoRegistro.put("Titulo_Ser",servicio.getTitulo());
            nuevoRegistro.put("Descripcion_Ser",servicio.getDescripcion());
            //nuevoRegistro.put("Estado",servicio.getEstado());
            nuevoRegistro.put("CodCategoria_Ser",servicio.getCategoria().getCodCategoria());
            cn.insert("Servicio",null,nuevoRegistro);
        } catch (Exception e) {
            e.printStackTrace();
            insert = false;
        } finally {
            cn.close();
        }
        return insert;
    }
    @Override
    public boolean editar(Servicio servicio, Context context) {
        boolean update = true;
        try {
            cn = new ConexionSQLiteHelper(context).getWritableDatabase();
            /*
            cn.execSQL("UPDATE Servicio SET Titulo_Ser = '"+ servicio.getTitulo()
                    +"' WHERE CodServicio_Ser = '" + servicio.getCodServicio() + "');");
            */

            ContentValues nuevoRegistro = new ContentValues();
            nuevoRegistro.put("Titulo_Ser",servicio.getTitulo());
            nuevoRegistro.put("Descripcion_Ser",servicio.getDescripcion());
            nuevoRegistro.put("Estado",servicio.getEstado());
            nuevoRegistro.put("CodCategoria_Ser",servicio.getCategoria().getCodCategoria());

            cn.update("Servicio",nuevoRegistro,"CodServicio_Ser = " +
                    Integer.toString(servicio.getCodServicio()),null);
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
            cn.execSQL("DELETE FROM Servicio WHERE CodServicio_Ser = " + id + ";");
            */
            cn.delete("Servicio","CodServicio_Ser = " + id,null);
        } catch (Exception e) {
            e.printStackTrace();
            delete = false;
        } finally {
            cn.close();
        }
        return delete;
    }
}
