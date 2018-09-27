package ex1.part1;

public class Modelo extends Marca {

  private int idModelo;
  private String nomeModelo;
  private String dadosModelo;
  private int numeroDePortas;

  public Modelo(int idModelo, String nomeModelo, String dadosModelo, int numeroDePortas,
      Marca marca) {
    super(marca.getIdMarca(), marca.getNomeMarca(), marca.getDadosMarca());
    this.idModelo = idModelo;
    this.nomeModelo = nomeModelo;
    this.dadosModelo = dadosModelo;
    this.numeroDePortas = numeroDePortas;
  }

  public int getIdModelo() {
    return this.idModelo;
  }

  public void setIdModelo(int idModelo) {
    this.idModelo = idModelo;
  }

  public String getNomeModelo() {
    return this.nomeModelo;
  }

  public void setNomeModelo(String nomeModelo) {
    this.nomeModelo = nomeModelo;
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
