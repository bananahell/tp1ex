package ex1.part1;

public class Modelo extends Marca {

  private int idModelo;
  private String dadosModelo;

  public Modelo() {
    this.idModelo = _MainClass.SEM_MODELO;
    this.dadosModelo = new String();
  }

  public Modelo(int idModelo, String dadosModelo, Marca marca) {
    super(marca.getIdMarca(), marca.getDadosMarca());
    this.idModelo = idModelo;
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

  public Marca getMarca() {
    return this;
  }

}
