package com.henriquesbraga.cepapp.activity.main;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.henriquesbraga.cepapp.R;
import com.henriquesbraga.cepapp.activity.result.ResultActivity;
import com.henriquesbraga.cepapp.model.CepEntity;

public class MainActivity extends AppCompatActivity implements MainView{

  TextInputLayout inputText;
  CepEntity cepEntity;
  MainPresenter presenter;
  Button button;
  ProgressDialog progress;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);


    inputText = (TextInputLayout) findViewById(R.id.inpt_cep);

    button = (Button) findViewById(R.id.btn_cep);
    presenter = new MainPresenter(this);

    button.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        String cep = inputText.getEditText().getText().toString();
        presenter.getData(cep);
      }
    });
  }

  @Override
  public void onRestart(){
    super.onRestart();
    inputText.getEditText().setText("");
  }

  @Override
  public void showLoading() {
    progress = new ProgressDialog(this);
    progress.setTitle("Buscando dados");
    progress.setMessage("Favor aguardar...");
    progress.setCancelable(false);
    progress.show();
  }

  @Override
  public void hideLoading() {
    progress.dismiss();
  }

  @Override
  public void onGetResult(CepEntity cepEntity) {
    Intent intent = new Intent();
    intent.setClass(MainActivity.this, ResultActivity.class);

    intent.putExtra("cep", cepEntity.getCep());
    intent.putExtra("logradouro", cepEntity.getLogradouro());
    intent.putExtra("complemento", cepEntity.getComplemento());

    intent.putExtra("bairro", cepEntity.getBairro());
    intent.putExtra("localidade", cepEntity.getLocalidade());
    intent.putExtra("uf", cepEntity.getUf());
    intent.putExtra("codmunicipio", cepEntity.getCodmunicipio());

    startActivity(intent);
    finishActivity(intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP);
  }

  @Override
  public void onResultError(String message) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
  }
}