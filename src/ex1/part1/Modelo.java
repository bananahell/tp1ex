package ex1.part1;

public class Modelo extends Marca {

  private int idModelo;
  private String dadosModelo;

  public Modelo() {
    this.idModelo = -1; // TODO procurar se id ta disponivel
    this.dadosModelo = new String();
  }

  public Modelo(int idModelo, String dadosModelo) {
    this.idModelo = idModelo; // TODO procurar se id ta disponivel
    this.dadosModelo = dadosModelo;
  }

  public int getIdModelo() {
    return this.idModelo;
  }

  public void setIdModelo(int idModelo) {
    this.idModelo = idModelo; // TODO procurar se id ta disponivel
  }

  public String getDadosModelo() {
    return this.dadosModelo;
  }

  public void setDadosModelo(String dadosModelo) {
    this.dadosModelo = dadosModelo;
  }

}
