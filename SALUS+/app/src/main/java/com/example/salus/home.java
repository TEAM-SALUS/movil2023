package com.example.salus;

import static com.example.salus.R.id.datePickerButton;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Calendar;

public class home extends AppCompatActivity
{
    private DatePickerDialog datePickerDialog;
    private Button dateButton;

    Button prof;
    Button serv;
    Button calend;
    Button logt;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initDatePicker();
        dateButton=findViewById(R.id.datePickerButton);
        dateButton.setText(getTodaysDate());
        prof = findViewById(R.id.button1);
        serv = findViewById(R.id.button2);
        calend = findViewById(R.id.button3);
        logt = findViewById(R.id.button4);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        Toast.makeText(home.this,extras.get("dniCliente").toString(), Toast.LENGTH_LONG).show();

        prof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(home.this,ProfesionalesActivity.class);
                i.putExtra("dniCliente",(int) extras.get("dniCliente"));
                startActivity(i);

            }
        });

        serv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent( home.this,Servicios.class);
                i.putExtra("dniCliente",(int) extras.get("dniCliente"));
                startActivity(i);
            }
        });

        calend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent ( home.this,TurneroActivity.class);
                i.putExtra("dniCliente",(int) extras.get("dniCliente"));
                startActivity(i);
            }
        });

        logt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i4 = new Intent( home.this,login.class);
                startActivity(i4);
            }
        });
    }

    private String getTodaysDate()
    {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        month = month + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        return makeDateString(day, month, year);
    }


    private void initDatePicker()
    {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day)
            {
                month = month + 1;
                String date = makeDateString(day,month,year);
                dateButton.setText(date);
            }
        };

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        datePickerDialog = new DatePickerDialog(this, dateSetListener, year, month, day);
        datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());

    }

    private String makeDateString(int day, int month, int year)
    {
        return getMonthFormat(month) + " " + day + " " + year;
    }

    private String getMonthFormat(int month)
    {
        if (month == 1)
            return "ENE";
        if (month == 2)
            return "FEB";
        if (month == 3)
            return "MAR";
        if (month == 4)
            return "ABR";
        if (month == 5)
            return "MAY";
        if (month == 6)
            return "JUN";
        if (month == 7)
            return "JUL";
        if (month == 8)
            return "AGO";
        if (month == 9)
            return "SEP";
        if (month == 10)
            return "OCT";
        if (month == 11)
            return "NOV";
        if (month == 12)
            return "DIC";

        //
        return "ENE";
    }

    public void openDatePicker(View view)
    {
        datePickerDialog.show();

    }

}