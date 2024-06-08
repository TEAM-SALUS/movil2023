package com.example.salus;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.salus.dao.URLConection;
import com.example.salus.entidad.PacienteRequest;
import com.example.salus.entidad.PacienteResponse;
import com.example.salus.entidad.RegisterRequest;
import com.example.salus.entidad.RegisterResponse;

import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegisterActivity extends AppCompatActivity {
    private EditText etUsername, etEmail, etPassword, etDni, etNombre, etApellido, etClave, etTelefono;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        etUsername = findViewById(R.id.etPacienteUser);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etClave);
        etDni = findViewById(R.id.etDniPaciente);
        etNombre = findViewById(R.id.etNombre);
        etApellido = findViewById(R.id.etApellido);
        etClave = findViewById(R.id.etClave);
        etTelefono = findViewById(R.id.etTelefono);
        btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateInputs()) {
                    registerUser();
                    Intent intent = new Intent(RegisterActivity.this, login.class);
                    startActivity(intent);
                }
            }
        });
    }

    private boolean validateInputs() {
        String username = etUsername.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        String dni = etDni.getText().toString().trim();
        String nombre = etNombre.getText().toString().trim();
        String apellido = etApellido.getText().toString().trim();
        String telefono = etTelefono.getText().toString().trim();

        if (username.isEmpty()) {
            etUsername.setError("El nombre de usuario es obligatorio");
            etUsername.requestFocus();
            return false;
        }

        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etEmail.setError("Introduce un email válido");
            etEmail.requestFocus();
            return false;
        }

        if (password.isEmpty() || password.length() < 6) {
            etPassword.setError("La contraseña debe tener al menos 6 caracteres");
            etPassword.requestFocus();
            return false;
        }

        if (dni.isEmpty() || !Pattern.matches("\\d{8,}", dni)) {
            etDni.setError("El DNI debe ser solo números y tener al menos 8 caracteres");
            etDni.requestFocus();
            return false;
        }

        if (nombre.isEmpty()) {
            etNombre.setError("El nombre es obligatorio");
            etNombre.requestFocus();
            return false;
        }

        if (apellido.isEmpty()) {
            etApellido.setError("El apellido es obligatorio");
            etApellido.requestFocus();
            return false;
        }

        if (telefono.isEmpty()) {
            etTelefono.setError("El teléfono es obligatorio");
            etTelefono.requestFocus();
            return false;
        }

        return true;
    }

    private void registerUser() {
        String username = etUsername.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        RegisterRequest registerRequest = new RegisterRequest(username, email, password);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URLConection.URLPrivada)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiDjango apiDjango = retrofit.create(ApiDjango.class);

        Call<RegisterResponse> call = apiDjango.registerUser(registerRequest);
        call.enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    String token = response.body().getToken();
                    registerPaciente(token);
                } else {
                    Toast.makeText(RegisterActivity.this, "Error en el registro de usuario", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                Toast.makeText(RegisterActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void registerPaciente(String token) {
        String dni = etDni.getText().toString().trim();
        String nombre = etNombre.getText().toString().trim();
        String apellido = etApellido.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String clave = etClave.getText().toString().trim();
        String telefono = etTelefono.getText().toString().trim();

        PacienteRequest pacienteRequest = new PacienteRequest(dni, nombre, apellido, email, clave, telefono);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URLConection.URLPrivada)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiDjango apiDjango = retrofit.create(ApiDjango.class);

        Call<PacienteResponse> call = apiDjango.registerPaciente("Token " + token, pacienteRequest);
        call.enqueue(new Callback<PacienteResponse>() {
            @Override
            public void onResponse(Call<PacienteResponse> call, Response<PacienteResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Toast.makeText(RegisterActivity.this, "Registro exitoso", Toast.LENGTH_SHORT).show();
                    // Redirigir a la pantalla de inicio de sesión o principal
                } else {
                    Toast.makeText(RegisterActivity.this, "Error en el registro del paciente", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<PacienteResponse> call, Throwable t) {
                Toast.makeText(RegisterActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}

