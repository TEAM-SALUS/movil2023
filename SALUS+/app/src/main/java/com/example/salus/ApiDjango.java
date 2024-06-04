package com.example.salus;

import com.example.salus.entidad.Autorizacion;
import com.example.salus.entidad.Medicos;
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
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;


public interface ApiDjango {
    @FormUrlEncoded
    @POST("login")
    Call<Autorizacion> LOGIN_CALL(
      @Field("username") String username,
      @Field("password") String password
    );


    //____ TURNOS ____
    @GET("turno")
    Call<List<Turno>> getTurnos();
    @DELETE("turno/{id}")
    Call<Void> eliminarTurno(@Path("id") int id);
    @PUT("turno/{id}")
    Call<Turno> actualizarTurno(@Path("id") @Body Turno turno);


    //____ REGISTRO ____
    @POST("registro")
    Call<RegisterResponse> registerUser(@Body RegisterRequest registerRequest);
    @POST("paciente-registro")
    Call<PacienteResponse> registerPaciente(@Header("Authorization") String token, @Body PacienteRequest pacienteRequest);



    //____ ESPECIALIDAD ____
    @GET("especialidad")
    Call<List<Especialidad>> getEspecialidades();


    @GET("medico")
    Call<List<Medicos>> getMedicos();


}

