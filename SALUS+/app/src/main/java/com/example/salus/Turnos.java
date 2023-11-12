package com.example.salus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

import com.example.salus.entidad.Turno;

import java.util.ArrayList;
import java.util.List;

public class Turnos extends AppCompatActivity {

    /*MyDatabaseHelper dbHelper = new MyDatabaseHelper(this);

    SQLiteDatabase db = dbHelper.getWritableDatabase();


    public class MyDatabaseHelper extends SQLiteOpenHelper {
        private static final int DATABASE_VERSION = 1;
        private static final String DATABASE_NAME = "MyDatabase";

        private static final String TABLE_NAME = "MyTable";
        private static final String COLUMN_ID = "id";
        private static final String COLUMN_NAME = "name";

        public MyDatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            //dbHelper = new MyDatabaseHelper(this);
            //dbHelper = new MyDatabaseHelper(this);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_NAME + " TEXT"
                    + ")";
            db.execSQL(CREATE_TABLE);
        }



        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);
        }

    }*/



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turnos);
    }

}