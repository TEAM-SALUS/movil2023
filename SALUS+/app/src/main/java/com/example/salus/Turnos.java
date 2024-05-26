package com.example.salus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

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

    /*________________________________________________________________________________________________*/
    /*Boton modificar al turnero
    Boton cancelar, abre ventana emergente y borrarlo de la BD*/

    TextView tv_especialidad, tv_profesional, tv_hora;
    Button btn_modificar, btn_cancelar;
    ImageButton turno_wpp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turnos);

        tv_especialidad = findViewById(R.id.tv_especialidad);
        tv_profesional = findViewById(R.id.tv_profesional);
        tv_hora = findViewById(R.id.tv_hora);
        btn_modificar = findViewById(R.id.btn_modificar);
        btn_cancelar = findViewById(R.id.btn_cancelar);
        turno_wpp = findViewById(R.id.turno_wpp);

        turno_wpp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String wppurl= "https://wa.me/+543525482570?text=¡Hola! Quiero solicitar información sobre los servicios y reservar un turno.";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(wppurl));
                startActivity(i);
            }
        });

        btn_modificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getTurno();
            }
        });
    }

    private void getTurno(){
        String api_url = "https://jsonplaceholder.typicode.com/posts/1";

        StringRequest getRequest = new StringRequest(Request.Method.GET, api_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);

                    // Traemos los elementos que nos dara la BD y pintamos los TextView con la información
                    tv_especialidad.setText(jsonObject.getString("title"));

                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        Volley.newRequestQueue(this).add(getRequest);

    }


}