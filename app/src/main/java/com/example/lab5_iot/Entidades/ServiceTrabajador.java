package com.example.lab5_iot.Entidades;

import com.example.lab5_iot.DTOs.DtoBuscarTrabajador;
import com.example.lab5_iot.DTOs.DtoBuscarTrabajadores;
import com.example.lab5_iot.DTOs.DtoResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface ServiceTrabajador {
    @GET("/trabajador/verTodo")
    Call<DtoBuscarTrabajadores> buscarTodosTrabajadores();

    @GET("/trabajador/verInfo")
    Call<DtoBuscarTrabajador> buscarTrabPorId (@Query("id") int id);

    @PUT("/tutor/asignarTutoria")
    Call<DtoResult> asignar(@Query("idEmployee") int idTrab, @Query("idTutor") int idTutor);

    @POST("/trabajador/feedback")
    Call<Feedback> postFeedback(@Query("employee_id") int codigo, @Query("employee_feedback") String feedback);

}
