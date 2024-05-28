package com.example.salus;

import com.example.salus.entidad.Autorizacion;
import com.example.salus.entidad.Turno;
import com.example.salus.entidad.Usuario;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import com.example.salus.entidad.Especialidad;
import com.example.salus.entidad.PacienteRequest;
import com.example.salus.entidad.PacienteResponse;
import com.example.salus.entidad.RegisterRequest;
import com.example.salus.entidad.RegisterResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.GET;
import retrofit2.http.POST;


public interface ApiDjango {
    @FormUrlEncoded
    @POST("login")
    Call<Autorizacion> LOGIN_CALL(
      @Field("username") String username,
      @Field("password") String password
    );

    @GET("turno")
    Call<List<Turno>> getTurnos();

    @POST("registro")
    Call<RegisterResponse> registerUser(@Body RegisterRequest registerRequest);

    @POST("paciente-registro")
    Call<PacienteResponse> registerPaciente(@Header("Authorization") String token, @Body PacienteRequest pacienteRequest);

    @GET("especialidad")
    Call<List<Especialidad>> getEspecialidades();
}

