package ex1.part1;

import java.util.Date;


public class Locacao {

  private int idLocacao;
  private Date dataHoraLocado;
  private Date dataHoraDevolvido;
  private int agenciaLocada;
  private int agenciaDevolvida;
  private int cpf;
  private String tipo;
  private double valor;
  private String placa;

  public Locacao() {
    this.idLocacao = Locadora.getUltimaLocacao() + 1;
    this.dataHoraLocado = new Date();
    this.dataHoraDevolvido = new Date();
    this.agenciaLocada = -1;
    this.agenciaDevolvida = -1;
    this.cpf = -1;
    this.tipo = new String();
    this.valor = -1;
    this.placa = new String();
  }

  public Locacao(Date dataHoraLocado, int agenciaLocada, int cpf, String tipo, double valor,
      String placa) {
    this.idLocacao = Locadora.getUltimaLocacao() + 1;
    this.dataHoraLocado = dataHoraLocado;
    this.dataHoraDevolvido = new Date();
    this.agenciaLocada = agenciaLocada;
    this.agenciaDevolvida = -1;
    this.cpf = cpf;
    this.tipo = tipo;
    this.valor = valor;
    this.placa = placa;
  }

  public Locacao(Date dataHoraLocado, Date dataHoraDevolvido, int agenciaLocada,
      int agenciaDevolvida, int cpf, String tipo, double valor, String placa) {
    this.idLocacao = Locadora.getUltimaLocacao() + 1;
    this.dataHoraLocado = dataHoraLocado;
    this.dataHoraDevolvido = dataHoraDevolvido;
    this.agenciaLocada = agenciaLocada;
    this.agenciaDevolvida = agenciaDevolvida;
    this.cpf = cpf;
    this.tipo = tipo;
    this.valor = valor;
    this.placa = placa;
  }

  public void calculaPreco() {
    System.out.println(this.cpf); // TODO
  }

  public int getIdLocacao() {
    return this.idLocacao;
  }

  public void setIdLocacao(int idLocacao) {
    this.idLocacao = idLocacao; // TODO procurar se id ta disponivel
  }

  public Date getDataHoraLocado() {
    return this.dataHoraLocado;
  }

  public void setDataHoraLocado(Date dataHoraLocado) {
    this.dataHoraLocado = dataHoraLocado;
  }

  public Date getDataHoraDevolvido() {
    return this.dataHoraDevolvido;
  }

  public void setDataHoraDevolvido(Date dataHoraDevolvido) {
    this.dataHoraDevolvido = dataHoraDevolvido;
  }

  public int getAgenciaLocada() {
    return this.agenciaLocada;
  }

  public void setAgenciaLocada(int agenciaLocada) {
    this.agenciaLocada = agenciaLocada;
  }

  public int getAgenciaDevolvida() {
    return this.agenciaDevolvida;
  }

  public void setAgenciaDevolvida(int agenciaDevolvida) {
    this.agenciaDevolvida = agenciaDevolvida;
  }

  public int getCpf() {
    return this.cpf;
  }

  public void setCpf(int cpf) {
    this.cpf = cpf;
  }

  public String getTipo() {
    return this.tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public double getValor() {
    return this.valor;
  }

  public void setValor(double valor) {
    this.valor = valor;
  }

  public String getPlaca() {
    return this.placa;
  }

  public void setPlaca(String placa) {
    this.placa = placa;
  }

}
