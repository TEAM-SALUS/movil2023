package com.example.salus;

import com.example.salus.entidad.Autorizacion;
import com.example.salus.entidad.Turno;
import com.example.salus.entidad.Usuario;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.Timer;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiDjango {
    @FormUrlEncoded
    @POST("login")
    Call<Autorizacion> LOGIN_CALL(
      @Field("username") String username,
      @Field("password") String password
    );

    @GET("turno")
    Call<List<Turno>> getTurnos();

}

