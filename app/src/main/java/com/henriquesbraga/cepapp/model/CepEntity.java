package com.henriquesbraga.cepapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CepEntity {
  @Expose
  @SerializedName("logradouro")
  private String logradouro;
  @Expose
  @SerializedName("cep")
  private String cep;
  @Expose
  @SerializedName("complemento")
  private String complemento;
  @Expose
  @SerializedName("bairro")
  private String bairro;
  @Expose
  @SerializedName("localidade")
  private String localidade;
  @Expose
  @SerializedName("uf")
  private String uf;
  @Expose
  @SerializedName("ibge")
  private String codmunicipio;

  @Expose
  @SerializedName("success")
  private Boolean sucess;

  public CepEntity(String logradouro, String cep, String complemento, String bairro, String localidade, String uf, String codmunicipio) {
    this.logradouro = logradouro;
    this.cep = cep;
    this.complemento = complemento;
    this.bairro = bairro;
    this.localidade = localidade;
    this.uf = uf;
    this.codmunicipio = codmunicipio;
  }

  public String getLogradouro() {
    return logradouro;
  }

  public void setLogradouro(String logradouro) {
    this.logradouro = logradouro;
  }

  public String getCep() {
    return cep;
  }

  public void setCep(String cep) {
    this.cep = cep;
  }

  public String getComplemento() {
    return complemento;
  }

  public void setComplemento(String complemento) {
    this.complemento = complemento;
  }

  public String getBairro() {
    return bairro;
  }

  public void setBairro(String bairro) {
    this.bairro = bairro;
  }

  public String getLocalidade() {
    return localidade;
  }

  public void setLocalidade(String localidade) {
    this.localidade = localidade;
  }

  public String getUf() {
    return uf;
  }

  public void setUf(String uf) {
    this.uf = uf;
  }

  public String getCodmunicipio() {
    return codmunicipio;
  }

  public void setCodmunicipio(String codmunicipio) {
    this.codmunicipio = codmunicipio;
  }

  public Boolean getSucess() {
    return sucess;
  }

  public void setSucess(Boolean sucess) {
    this.sucess = sucess;
  }
}
