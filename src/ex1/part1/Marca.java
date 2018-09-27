package ex1.part1;

public class Marca {

  private int idMarca;
  private String dadosMarca;

  public Marca(int idMarca, String dadosMarca) {
    this.idMarca = idMarca;
    this.dadosMarca = dadosMarca;
  }

  public int getIdMarca() {
    return this.idMarca;
  }

  public void setIdMarca(int idMarca) {
    this.idMarca = idMarca; // TODO procurar se id ta disponivel
  }

  public String getDadosMarca() {
    return this.dadosMarca;
  }

  public void setDadosMarca(String dadosMarca) {
    this.dadosMarca = dadosMarca;
  }

}
