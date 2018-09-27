package ex1.part1;

public class Modelo extends Marca {

  private int idModelo;
  private String dadosModelo;
  private int numeroDePortas;

  public Modelo(int idModelo, String dadosModelo, int numeroDePortas, Marca marca) {
    super(marca.getIdMarca(), marca.getDadosMarca());
    this.idModelo = idModelo;
    this.dadosModelo = dadosModelo;
    this.numeroDePortas = numeroDePortas;
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

  public int getNumeroDePortas() {
    return this.numeroDePortas;
  }

  public void setNumeroDePortas(int numeroDePortas) {
    this.numeroDePortas = numeroDePortas;
  }

  public Marca getMarca() {
    return this;
  }

}
