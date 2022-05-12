package com.cb.apiandroid.modelo;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyApiService {


    @GET("pokemon/")
    Call<ResultPokemon> getPokemon();
}
