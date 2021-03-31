package com.henriquesbraga.cepapp.api;

import com.henriquesbraga.cepapp.model.CepEntity;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {
  @GET("ws/{cep}/json")
  Call<CepEntity> getdata(@Path("cep") String cep);
}
