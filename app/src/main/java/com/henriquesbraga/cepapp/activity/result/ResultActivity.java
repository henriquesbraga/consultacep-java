package com.henriquesbraga.cepapp.activity.result;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.henriquesbraga.cepapp.R;

public class ResultActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_result);

    getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

    TextView txt_cep = (TextView) findViewById(R.id.txt_cep);
    TextView txt_logradouro = (TextView) findViewById(R.id.txt_logradouro);
    TextView txt_complemento = (TextView) findViewById(R.id.txt_complemento);
    TextView txt_bairro = (TextView) findViewById(R.id.txt_bairro);
    TextView txt_localidade = (TextView) findViewById(R.id.txt_localidade);
    TextView txt_uf = (TextView) findViewById(R.id.txt_uf);
    TextView txt_codmunicipio = (TextView) findViewById(R.id.txt_codmunicipio);

    Intent it = getIntent();

    String cep = it.getStringExtra("cep");
    String logradouro = it.getStringExtra("logradouro");
    String complemento = it.getStringExtra("complemento");
    String bairro = it.getStringExtra("bairro");
    String localidade = it.getStringExtra("localidade");
    String uf = it.getStringExtra("uf");
    String codmunicipio = it.getStringExtra("codmunicipio");

    txt_cep.setText(cep);
    txt_logradouro.setText(logradouro);
    txt_complemento.setText(complemento);
    txt_bairro.setText(bairro);
    txt_localidade.setText(localidade);
    txt_uf.setText(uf);
    txt_codmunicipio.setText(codmunicipio);
  }

}