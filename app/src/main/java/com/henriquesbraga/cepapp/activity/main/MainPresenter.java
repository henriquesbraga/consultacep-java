package com.henriquesbraga.cepapp.activity.main;

import androidx.annotation.NonNull;

import com.henriquesbraga.cepapp.api.ApiClient;
import com.henriquesbraga.cepapp.api.ApiInterface;
import com.henriquesbraga.cepapp.model.CepEntity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter {
  private MainView view;

  public MainPresenter(MainView view){
    this.view = view;
  }

  void getData(String cep){
    view.showLoading();
    ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
    Call<CepEntity> call = apiInterface.getdata(cep);
    call.enqueue(new Callback<CepEntity>() {
      @Override
      public void onResponse(@NonNull Call<CepEntity> call, @NonNull Response<CepEntity> response) {
        view.hideLoading();
        if(response.isSuccessful() && response.body() != null){
          view.onGetResult(response.body());
        }
        else if(response.body() == null){
          view.onResultError("Erro no cep");
        }
      }

      @Override
      public void onFailure(@NonNull Call<CepEntity> call, @NonNull Throwable t) {
        view.hideLoading();
        view.onResultError(t.getLocalizedMessage());
      }
    });
  }

}
