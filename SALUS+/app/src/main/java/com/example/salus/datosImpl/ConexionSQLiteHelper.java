package com.example.salus.datosImpl;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.salus.entidad.Base;

public class ConexionSQLiteHelper extends SQLiteOpenHelper {
    private Base base;
    public ConexionSQLiteHelper(@Nullable Context context) {
        super(context, Base.getNombreBase(), null, Base.getVersionBase());
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(base.getSqlCreateTableCondicion());
        db.execSQL(base.getSqlCreateTableUsuario());
        db.execSQL(base.getSqlCreateTableCategoria());
        db.execSQL(base.getSqlCreateTableServicio());
        db.execSQL(base.getSqlCreateTableServicioXProfesional());
        db.execSQL(base.getSqlCreateTableTurno());
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(base.getSqlDropTableTurno());
        db.execSQL(base.getSqlDropTableServicioXProfesional());
        db.execSQL(base.getSqlDropTableServicio());
        db.execSQL(base.getSqlDropTableCategoria());
        db.execSQL(base.getSqlDropTableUsuario());
        db.execSQL(base.getSqlDropTableCondicion());

        db.execSQL(base.getSqlCreateTableCondicion());
        db.execSQL(base.getSqlCreateTableUsuario());
        db.execSQL(base.getSqlCreateTableCategoria());
        db.execSQL(base.getSqlCreateTableServicio());
        db.execSQL(base.getSqlCreateTableServicioXProfesional());
        db.execSQL(base.getSqlCreateTableTurno());

        base.setVersionBase(newVersion);
    }
}
