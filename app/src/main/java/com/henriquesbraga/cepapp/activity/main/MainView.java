package com.henriquesbraga.cepapp.activity.main;

import com.henriquesbraga.cepapp.model.CepEntity;

public interface MainView {
  void showLoading();
  void hideLoading();
  void onGetResult(CepEntity cepEntity);
  void onResultError(String message);
}
