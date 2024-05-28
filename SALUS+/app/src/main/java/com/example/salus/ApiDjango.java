package com.example.salus;

import androidx.room.vo.Field;

import com.example.salus.entidad.Autorizacion;
import com.example.salus.entidad.Especialidad;
import com.example.salus.entidad.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.GET;

public interface ApiDjango {
    @FormUrlEncoded
    @POST("login")
    Call<Autorizacion> LOGIN_CALL(
      @Field("username") String username,
      @Field("password") String password
    );
    @GET("especialidad")
    Call<List<Especialidad>> getEspecialidades();
}
