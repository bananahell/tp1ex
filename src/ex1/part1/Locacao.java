package ex1.part1;

import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;


public class Locacao {

  public static int LOCACAO_DIARIA = 1;
  public static int LOCACAO_TEMPO = 2;

  private int idLocacao;
  private LocalDateTime dataHoraLocado;
  private LocalDateTime dataHoraDevolvido;
  private int dias;
  private int agenciaLocada;
  private int agenciaDevolvida;
  private int cpf;
  private int tipo;
  private double valor;
  private String placa;

  Statement stmt = null;
  ResultSet rs = null;

  public Locacao(int agenciaLocada, int cpf, int tipo, String placa) {
    this.idLocacao = Locadora.getUltimaLocacao() + 1;
    this.dataHoraLocado = LocalDateTime.now();
    this.dataHoraDevolvido = null;
    this.agenciaLocada = agenciaLocada;
    this.cpf = cpf;
    this.tipo = tipo;
    this.placa = placa;
  }

  public Locacao(int dias, int agenciaLocada, int agenciaDevolvida, int cpf, int tipo,
      String placa) {
    this.idLocacao = Locadora.getUltimaLocacao() + 1;
    this.dataHoraLocado = LocalDateTime.now();
    this.dias = dias;
    this.dataHoraDevolvido = LocalDateTime.from(this.dataHoraLocado).plusDays(dias);
    this.agenciaLocada = agenciaLocada;
    this.agenciaDevolvida = agenciaDevolvida;
    this.cpf = cpf;
    this.tipo = tipo;
    this.placa = placa;
    this.valor = this.calculaPreco();
  }

  public double calculaPreco() {
    if (this.tipo == Locacao.LOCACAO_TEMPO) { // Locação a ser devolvida ainda
      try {
        this.dataHoraDevolvido = LocalDateTime.now();
        int tempo = this.dataHoraDevolvido.compareTo(this.dataHoraLocado);
        this.stmt = _MainClass.conn.createStatement();
        this.rs = this.stmt.executeQuery("SELECT valor FROM automovel WHERE placa = " + this.placa);
        this.rs.next();
        // TODO aplica-se aqui a regra de negócio. definir o preço
        // aqui
        this.valor = tempo * this.rs.getDouble(1);
      } catch (Exception e) {
        System.err.println(e.getMessage());
        System.err.println("Deu problema ao calcular o preço!");
      }
    } else { // Locação por diária
      try {
        this.dataHoraDevolvido = this.dataHoraLocado.plusDays(this.dias);
        this.stmt = _MainClass.conn.createStatement();
        this.rs = this.stmt
            .executeQuery("SELECT valor FROM automovel WHERE placa = '" + this.placa + "'");
        this.rs.next();
        // TODO aplica-se aqui a regra de negócio. definir o preço
        // aqui
        this.valor = this.dias * this.rs.getDouble(1);
      } catch (Exception e) {
        System.err.println(e.getMessage());
        System.err.println("Deu problema ao calcular o preço!");
      }
    }
    return this.valor;
  }

  public int getIdLocacao() {
    return this.idLocacao;
  }

  public LocalDateTime getDataHoraLocado() {
    return this.dataHoraLocado;
  }

  public void setDataHoraLocado(LocalDateTime dataHoraLocado) {
    this.dataHoraLocado = dataHoraLocado;
  }

  public LocalDateTime getDataHoraDevolvido() {
    return this.dataHoraDevolvido;
  }

  public void setDataHoraDevolvido(LocalDateTime dataHoraDevolvido) {
    this.dataHoraDevolvido = dataHoraDevolvido;
  }

  public int getDias() {
    return this.dias;
  }

  public void setDias(int dias) {
    this.dias = dias;
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

  public int getTipo() {
    return this.tipo;
  }

  public void setTipo(int tipo) {
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
