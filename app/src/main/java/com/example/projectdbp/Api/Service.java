package com.example.projectdbp.Api;

import com.example.projectdbp.Models.Paciente;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
public interface Service {
    @GET("paciente")
    public abstract Call<List<Paciente>> listPaciente();
    @POST("paciente/agregar")
    public abstract Call<Paciente> addPaciente(@Body Paciente obj);
    @PUT("paciente/modificar")
    public abstract Call<Paciente> modifyPaciente(@Body Paciente obj);
    @DELETE("paciente/eliminar/{id}")
    public abstract Call<Paciente> removePaciente(@Path("id") int id);
}
