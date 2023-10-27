package com.example.salus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = getApplicationContext();
    }

    public void irLogin(View view) {
        Intent intent = new Intent(this, login.class);
        startActivity(intent);

    }

    public void irSignUp(View view) {
        Intent intent = new Intent(this, SignUp.class);
        startActivity(intent);

    }

}