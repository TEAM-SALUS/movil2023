package com.example.salus;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Calendar;

public class TurneroActivity extends AppCompatActivity {

    private Spinner spinnerDoctor;
    private DatePicker datePicker;
    private TimePicker timePicker;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turnero);

        spinnerDoctor = findViewById(R.id.spinnerDoctor);
        datePicker = findViewById(R.id.datePicker);
        timePicker = findViewById(R.id.timePicker);
        btnSubmit = findViewById(R.id.btnSubmit);

        // Configurar Spinner con una lista de doctores
        ArrayList<String> doctorList = new ArrayList<>();
        doctorList.add("Dr. Smith");
        doctorList.add("Dr. Johnson");
        doctorList.add("Dr. Williams");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, doctorList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDoctor.setAdapter(adapter);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedDoctor = spinnerDoctor.getSelectedItem().toString();
                int day = datePicker.getDayOfMonth();
                int month = datePicker.getMonth();
                int year = datePicker.getYear();
                int hour = timePicker.getHour();
                int minute = timePicker.getMinute();

                String appointmentDetails = "Doctor: " + selectedDoctor + "\n" +
                        "Date: " + day + "/" + (month + 1) + "/" + year + "\n" +
                        "Time: " + String.format("%02d:%02d", hour, minute);

                Toast.makeText(TurneroActivity.this, appointmentDetails, Toast.LENGTH_LONG).show();
            }
        });
    }
}

