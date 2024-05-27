package com.example.salus;

import com.example.salus.entidad.Autorizacion;
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

public interface ApiDjango {
    @FormUrlEncoded
    @POST("login")
    Call<Autorizacion> LOGIN_CALL(
      @Field("username") String username,
      @Field("password") String password
    );
    @POST("registro")
    Call<RegisterResponse> registerUser(@Body RegisterRequest registerRequest);

    @POST("paciente-registro")
    Call<PacienteResponse> registerPaciente(@Header("Authorization") String token, @Body PacienteRequest pacienteRequest);
    @GET("especialidad")
    Call<List<Especialidad>> getEspecialidades();
}
